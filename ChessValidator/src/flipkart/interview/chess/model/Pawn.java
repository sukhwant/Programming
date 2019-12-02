package flipkart.interview.chess.model;

public class Pawn extends Piece {

	public Pawn(Color color, String representation) {
		this.setColor(color);
		this.setRepresentation(representation);
	}

	@Override
	public boolean validateMove(Position initialPosition, Position finalPosition, Board board) {
		if (this.color == Color.WHITE && finalPosition.getX() == initialPosition.getX() + 1
				&& finalPosition.getY() == initialPosition.getY()) {
			validateForPiece(board, finalPosition, false);
		} else if (this.color == Color.WHITE && finalPosition.getX() == initialPosition.getX() + 1
				&& finalPosition.getY() == initialPosition.getY() + 1) {
			validateForPiece(board, finalPosition, true);
		} else if (this.color == Color.WHITE && finalPosition.getX() == initialPosition.getX() + 1
				&& finalPosition.getY() == initialPosition.getY() - 1) {
			validateForPiece(board, finalPosition, true);
		} else if (this.color == Color.BLACK && finalPosition.getX() == initialPosition.getX() - 1
				&& finalPosition.getY() == initialPosition.getY()) {
			validateForPiece(board, finalPosition, false);
		} else if (this.color == Color.BLACK && finalPosition.getX() == initialPosition.getX() - 1
				&& finalPosition.getY() == initialPosition.getY() + 1) {
			validateForPiece(board, finalPosition, true);
		} else if (this.color == Color.BLACK && finalPosition.getX() == initialPosition.getX() - 1
				&& finalPosition.getY() == initialPosition.getY() - 1) {
			validateForPiece(board, finalPosition, true);
		} else {
			return false;
		}
		return true;
	}

	private void validateForPiece(Board board, Position finalPosition, boolean diagonalMove) {
		Cell cell = board.getCellAt(finalPosition);
		if ((diagonalMove && cell.isEmpty())) {
			throw new IllegalArgumentException("Invalid move...");
		} else if (diagonalMove && cell.getPiece().getColor().equals(this.color)) {
			throw new IllegalArgumentException("Invalid move...");
		} else if (!diagonalMove && !cell.isEmpty()) {
			throw new IllegalArgumentException("Invalid move...");
		} else {
			// Good. Capture.
		}
	}
}
