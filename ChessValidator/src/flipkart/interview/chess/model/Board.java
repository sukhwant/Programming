package flipkart.interview.chess.model;

public class Board {

	private Cell[][] board;

	public Cell[][] getBoard() {
		return board;
	}

	public void setBoard(Cell[][] board) {
		this.board = board;
	}

	public Board() {
		board = new Cell[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Cell(i, j, true);
			}
		}
	}

	public Board(String[][] input) {
		board = new Cell[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Piece piece = PieceUtil.getPieceFromString(input[i][j]);
				if (piece != null) {
					Cell cell = new Cell(i, j, false);
					cell.setPiece(piece);
					board[i][j] = cell;

				} else {
					board[i][j] = new Cell(i, j, false);
				}
			}
		}
	}

	public boolean isCellEmpty(int xPos, int yPos) {
		return board[xPos][yPos].isEmpty();
	}

	public void performMove(Position intialPosition, Position finalPosition, Piece piece) {
		board[finalPosition.getX()][finalPosition.getY()].setPiece(piece);
		board[intialPosition.getX()][intialPosition.getY()].setEmpty(true);
	}

	public Cell getCellAt(Position position) {
		// TODO:- Validate.
		return board[position.getX()][position.getY()];
	}

	public void print() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (this.getCellAt(new Position(i, j)).isEmpty()) {
					System.out.print("--" + " ");
				} else {
					System.out.print(this.getCellAt(new Position(i, j)).getPiece().getRepresentation() + " ");
				}
			}
			System.out.println();
		}
	}

}
