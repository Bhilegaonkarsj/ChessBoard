
//Pradhan
public class Queen extends Piece {

	public Queen(boolean isWhite) {
		super(isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Board board, int srcRow, int srcCol, int destRow, int destCol) {
		 int rowDiff = Math.abs(destRow - srcRow);
	        int colDiff = Math.abs(destCol - srcCol);

	        // Queen moves like rook or bishop
	        if (srcRow == destRow || srcCol == destCol) {
	            // Rook-like move
	            return new Rook(isWhite).isValidMove(board, srcRow, srcCol, destRow, destCol);
	        } else if (rowDiff == colDiff) {
	            // Bishop-like move
	            return new Bishop(isWhite).isValidMove(board, srcRow, srcCol, destRow, destCol);
	        }
	        return false;
	}

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return isWhite? '\u2655' : '\u265B';
	}

	
}
