package flipkart.interview.chess.model;

public class Chess {

	Board board;

	public Chess(String[][] input) {
		board = new Board(input);
	}

	public Chess() {
		board = new Board();
	}

	public void print() {
		System.out.println("------------------------");
		board.print();
		System.out.println("------------------------");
	}

	public void move(String input, String start, String end) {
		int initialXPos = Character.getNumericValue(start.charAt(0));
		int initialYPos = Character.getNumericValue(start.charAt(1));

		int finalXPos = Character.getNumericValue(end.charAt(0));
		int finalYPos = Character.getNumericValue(end.charAt(1));
		try {
			performMove(input, new Position(initialXPos, initialYPos), new Position(finalXPos, finalYPos));
		} catch (Exception e) {
			System.out.println("Invalid Move");
		}
	}

	private void performMove(String input, Position initialPosition, Position finalPosition) {
		Piece piece = PieceUtil.getPieceFromString(input);
		checkIfExist(initialPosition, piece);
		if (piece.validateMove(initialPosition, finalPosition, board)) {
			performMove(initialPosition, finalPosition, piece);
		} else {
			throw new IllegalArgumentException("Invalid move...");
		}
	}

	private void checkIfExist(Position initialPosition, Piece piece) {
		if (!board.getCellAt(initialPosition).getPiece().equals(piece)) {
			throw new IllegalArgumentException("Invalid move... Piece not present");
		}
	}

	private void performMove(Position initialPosition, Position finalPosition, Piece piece) {
		board.performMove(initialPosition, finalPosition, piece);
	}
}
