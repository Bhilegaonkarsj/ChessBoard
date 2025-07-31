import java.util.Scanner;

public class ChessGame {

	private Board board;
	private boolean whiteTurn;
	
	
	public ChessGame() {
		board=new Board();
		whiteTurn=true;
	}
	
	public void start() {
		
		Scanner sc =new Scanner(System.in);
		
		while(true) {
		board.printBoard();
		System.out.println(whiteTurn?"White":"Black"+" 's move :");
		String move=sc.nextLine().trim();
		
		if(move.equalsIgnoreCase("exit")) break;
		
		String [] parts=move.split(" ");
		if(parts.length!=2) {
			System.out.println("invalid format");
			continue;
		}
		
		int[]src=parse(parts[0]);
		int[]dest=parse(parts[1]);
		if(src==null || dest==null) {
			System.out.println("Wrong coordinates");
			  continue;
        }

        Piece piece = board.getPiece(src[0], src[1]);
        if (piece == null || piece.isWhite() != whiteTurn) {
            System.out.println("Invalid piece.");
            continue;
        }

        if (piece.isValidMove(board, src[0], src[1], dest[0], dest[1])) {
            board.move(src[0], src[1], dest[0], dest[1]);
            whiteTurn = !whiteTurn;
        } else {
            System.out.println("Illegal move.");
        }
    }

    sc.close();
	}
	
	
	
    private int[] parse(String pos) {
        if (pos.length() != 2) return null;
        int col = pos.charAt(0) - 'a';
        int row = 8 - (pos.charAt(1) - '0');
        if (row < 0 || row > 7 || col < 0 || col > 7) return null;
        return new int[]{row, col};
    }
    
    
	public static void main(String[] args) {
		
		ChessGame c=new ChessGame();
		c.start();
		
	}
}
