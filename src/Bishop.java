
//Unt
public class Bishop extends Piece {

	public Bishop(boolean isWhite) {
		super(isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Board board, int srcRow, int srcCol, int destRow, int destCol) {
		// TODO Auto-generated method stub
		 int rowDiff = Math.abs(destRow - srcRow);
	        int colDiff = Math.abs(destCol - srcCol);

	        // Bishop moves diagonally only
	        if (rowDiff != colDiff) return false;

	        int rowStep = (destRow - srcRow) > 0 ? 1 : -1;
	        int colStep = (destCol - srcCol) > 0 ? 1 : -1;

	        int row = srcRow + rowStep;
	        int col = srcCol + colStep;

	        // Check all squares along the diagonal path
	        while (row != destRow && col != destCol) {
	            if (board.getPiece(row, col) != null) return false;
	            row += rowStep;
	            col += colStep;
	        }

	        // Check destination square: must be empty or have opponent's piece
	        Piece destPiece = board.getPiece(destRow, destCol);
	        return destPiece == null || destPiece.isWhite() != this.isWhite();
	    }

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return isWhite? '\u2657' : '\u265D';
	}

}
