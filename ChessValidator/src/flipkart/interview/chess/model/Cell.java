package flipkart.interview.chess.model;

public class Cell {

	private boolean isEmpty;
	private Position position;

	private Piece piece;

	public Cell(int xPos, int yPos, boolean isEmpty) {
		this.position = new Position(xPos, yPos);
		this.isEmpty = true;
		this.piece = null;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.isEmpty = false;
		this.piece = piece;
	}

	public void removePiece() {
		this.isEmpty = true;
		this.piece = null;
	}
}
