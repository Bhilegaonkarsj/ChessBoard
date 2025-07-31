
//Hatti
public class Rook extends Piece{

	public Rook(boolean isWhite) {
		super(isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Board board, int srcRow, int srcCol, int destRow, int destCol) {
		// TODO Auto-generated method stub
		 if (srcRow != destRow && srcCol != destCol) return false;

		    // Check if path is clear (either row or column movement)
		    int rowStep = Integer.compare(destRow, srcRow);
		    int colStep = Integer.compare(destCol, srcCol);

		    int row = srcRow + rowStep;
		    int col = srcCol + colStep;

		    while (row != destRow || col != destCol) {
		        if (board.getPiece(row, col) != null) return false;
		        row += rowStep;
		        col += colStep;
		    }

		    Piece destPiece = board.getPiece(destRow, destCol);
		    return destPiece == null || destPiece.isWhite() != this.isWhite();
	}

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return isWhite? '\u2656' : '\u265C';

	}

}
