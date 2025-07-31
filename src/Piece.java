
public abstract class Piece {

	protected boolean isWhite;

	public Piece(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public boolean isWhite() {
		return isWhite;
	}


    public abstract boolean isValidMove(Board board, int srcRow, int srcCol, int destRow, int destCol);
    public abstract char getSymbol();

	
	
}
