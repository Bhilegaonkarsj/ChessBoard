
public class Board {

	private Piece[][] board;

	public Board() {
		board=new Piece[8][8];
		intialize();
	}

	private void intialize() {
		// TODO Auto-generated method stub
		
		//pawn -pyada
		for(int i=0;i<8;i++) {
			board[1][i]=new Pawn(false);
			board[6][i]=new Pawn(true);

		}
		
		 // Rooks
	    board[0][0] = new Rook(false);
	    board[0][7] = new Rook(false);
	    board[7][0] = new Rook(true);
	    board[7][7] = new Rook(true);

	    // Knights
	    board[0][1] = new Knight(false);
	    board[0][6] = new Knight(false);
	    board[7][1] = new Knight(true);
	    board[7][6] = new Knight(true);

	    // Bishops
	    board[0][2] = new Bishop(false);
	    board[0][5] = new Bishop(false);
	    board[7][2] = new Bishop(true);
	    board[7][5] = new Bishop(true);

	    // Queens
	    board[0][3] = new Queen(false);
	    board[7][3] = new Queen(true);

	    // Kings
	    board[0][4] = new King(false);
	    board[7][4] = new King(true);
	}

	public Piece getPiece(int row, int col) {
		// TODO Auto-generated method stub
		return board[row][col];
	}

	public Piece[][] getBoard() {
		return board;
	}

	public void setPiece(int row, int col, Piece piece) {
     board[row][col]=piece;
	}
	
	
	public void move(int srcRow,int srcCol, int destRow,int destCol) {
		
		setPiece(destRow,destCol,getPiece(srcRow, srcCol));
		setPiece(srcRow,srcCol,null);
	}
	
	
	public void printBoard() {
		
		
		for(int row=0;row<8;row++) {
			System.out.print(8-row+" ");
			for(int col=0;col<8;col++) {
				Piece p=board[row][col];
				System.out.print(p==null?". ":p.getSymbol()+" ");
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	
}
