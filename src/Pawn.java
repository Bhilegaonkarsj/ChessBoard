
public class Pawn extends Piece {

	
	public Pawn(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public boolean isValidMove(Board board, int srcRow, int srcCol, int destRow, int destCol) {
		// TODO Auto-generated method stub
		
		
		

		int direction=isWhite? -1:1;
		int startRow=isWhite? 6:1;
		
		
//		ek paul pudhe
		if(srcCol==destCol) {
			if(board.getPiece(destRow,destCol)==null) {
				if(destRow-srcRow==direction) return true;
				if(srcRow==startRow && destRow-srcRow==2*direction 
						&& board.getPiece(srcRow+direction, destCol)==null) return true;
			}
		}
		
		
		//diagonally - tirap chal
		
		if(Math.abs(destCol-srcCol)==1 && destRow-srcRow==direction) {
			Piece p=board.getPiece(destRow, destCol);
			
			return p!=null && p.isWhite()!=this.isWhite();
		}
		return false;
	}

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		
		return isWhite?'\u2659' : '\u265F';
	}
	
}
