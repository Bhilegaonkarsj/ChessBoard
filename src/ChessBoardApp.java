import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ChessBoardApp extends Application {

    private Board board = new Board();
    private GridPane grid = new GridPane();
    private int selectedRow = -1;
    private int selectedCol = -1;
    private boolean whiteTurn = true;

    private Label whiteTimerLabel = new Label("White: 05:00");
    private Label blackTimerLabel = new Label("Black: 05:00");

    private int whiteTime = 300; // 5 minutes in seconds
    private int blackTime = 300;
    private Timeline timer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        HBox timerBox = new HBox(20, whiteTimerLabel, blackTimerLabel);
        timerBox.setStyle("-fx-padding: 10; -fx-alignment: center; -fx-font-size: 16px;");

        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-padding: 20px;");

        updateBoardUI(grid);

        root.getChildren().addAll(timerBox, grid);

        startTimer();

        Scene scene = new Scene(root, 700, 760);
        primaryStage.setTitle("JavaFX Chessboard with Timer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateBoardUI(GridPane grid) {
        grid.getChildren().clear();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Button btn = new Button();
                btn.setPrefSize(80, 80);
                Piece piece = board.getPiece(row, col);

                if (piece != null) {
                    btn.setText(String.valueOf(piece.getSymbol()));
                    btn.setFont(Font.font(30));
                }

                if ((row + col) % 2 == 0) {
                    btn.setStyle("-fx-background-color: #f0d9b5;");
                } else {
                    btn.setStyle("-fx-background-color: #b58863;");
                }

                int r = row;
                int c = col;

                btn.setOnAction(e -> {
                    handleCellClick(r, c, btn);
                });

                grid.add(btn, col, row);
            }
        }
    }

    private void handleCellClick(int row, int col, Button btn) {
        if (selectedRow == -1 && selectedCol == -1) {
            // First click — select a piece
            Piece selectedPiece = board.getPiece(row, col);
            if (selectedPiece != null && selectedPiece.isWhite() == whiteTurn) {
                selectedRow = row;
                selectedCol = col;
                btn.setStyle("-fx-background-color: yellow");
            }
        } else {
            // Second click — move attempt
            Piece selectedPiece = board.getPiece(selectedRow, selectedCol);
            if (selectedPiece != null && selectedPiece.isValidMove(board, selectedRow, selectedCol, row, col)) {
                board.move(selectedRow, selectedCol, row, col);
                whiteTurn = !whiteTurn; // switch turn
            }

            selectedRow = -1;
            selectedCol = -1;
            updateBoardUI(grid);
        }
    }

    private void startTimer() {
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (whiteTurn) {
                whiteTime--;
                if (whiteTime <= 0) {
                    whiteTimerLabel.setText("White: 00:00");
                    timer.stop();
                    showGameOver("Black wins! (White ran out of time)");
                } else {
                    whiteTimerLabel.setText("White: " + formatTime(whiteTime));
                }
            } else {
                blackTime--;
                if (blackTime <= 0) {
                    blackTimerLabel.setText("Black: 00:00");
                    timer.stop();
                    showGameOver("White wins! (Black ran out of time)");
                } else {
                    blackTimerLabel.setText("Black: " + formatTime(blackTime));
                }
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d", minutes, secs);
    }

    private void showGameOver(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
