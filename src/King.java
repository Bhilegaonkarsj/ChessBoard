
//Raja
public class King extends Piece{

	public King(boolean isWhite) {
		super(isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Board board, int srcRow, int srcCol, int destRow, int destCol) {
		 int rowDiff = Math.abs(destRow - srcRow);
	        int colDiff = Math.abs(destCol - srcCol);

	        if ((rowDiff <= 1) && (colDiff <= 1)) {
	            Piece destPiece = board.getPiece(destRow, destCol);
	            return destPiece == null || destPiece.isWhite() != this.isWhite();
	        }

	        return false;
	    }

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return isWhite? '\u2654' : '\u265A';
	}
	
	

}
