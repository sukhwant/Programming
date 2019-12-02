package flipkart.interview.chess.model;

public class Rook extends Piece {

	public Rook(Color color, String representation) {
		this.setColor(color);
		this.setRepresentation(representation);
	}

	@Override
	public boolean validateMove(Position initialPosition, Position finalPosition, Board board) {
		if (initialPosition.getX() == finalPosition.getX()) {
			return (horizontalMove(initialPosition, finalPosition, board));
		} else if (initialPosition.getY() == finalPosition.getY()) {
			return (verticalMove(initialPosition, finalPosition, board));
		}
		return false;
	}

	private boolean verticalMove(Position initialPosition, Position finalPosition, Board board) {
		for (int i = initialPosition.getX() + 1; i < finalPosition.getX(); i++) {
			Cell cell = board.getCellAt(new Position(i, initialPosition.getY()));
			if (!cell.isEmpty()) {
				return false;
			}
		}
		Cell cell = board.getCellAt(new Position(finalPosition.getX(), finalPosition.getY()));
		if (cell.isEmpty()) {
			return true;
		} else {
			return (!cell.getPiece().getColor().equals(this.color));
		}
	}

	private boolean horizontalMove(Position initialPosition, Position finalPosition, Board board) {
		for (int i = initialPosition.getY() + 1; i < finalPosition.getY(); i++) {
			Cell cell = board.getCellAt(new Position(initialPosition.getX(), i));
			if (!cell.isEmpty()) {
				return false;
			}
		}
		Cell cell = board.getCellAt(new Position(finalPosition.getX(), finalPosition.getY()));
		if (cell.isEmpty()) {
			return true;
		} else {
			return (!cell.getPiece().getColor().equals(this.color));
		}
	}

}
