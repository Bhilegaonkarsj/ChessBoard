
//Ghoda
public class Knight extends Piece {

	public Knight(boolean isWhite) {
		super(isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Board board, int srcRow, int srcCol, int destRow, int destCol) {
		// TODO Auto-generated method stub
		
		int rowDiff = Math.abs(srcRow - destRow);
	    int colDiff = Math.abs(srcCol - destCol);

	    //Row=2then col=1  or Col=2 then row=1 (L shape)
	    if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
	        Piece destPiece = board.getPiece(destRow, destCol);
	        return destPiece == null || destPiece.isWhite() != this.isWhite();
	    }
	    return false;
	    }

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return isWhite?'\u2658' : '\u265E'; 
	}

}
