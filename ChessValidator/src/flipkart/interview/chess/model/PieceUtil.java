package flipkart.interview.chess.model;

import java.util.HashMap;
import java.util.Map;

public class PieceUtil {

	static Map<String, Piece> stringToPieceMap = new HashMap<>();

	static {
		stringToPieceMap.put("WP", new Pawn(Color.WHITE, "WP"));
		stringToPieceMap.put("BP", new Pawn(Color.BLACK, "BP"));

		stringToPieceMap.put("BR", new Rook(Color.BLACK, "BR"));
		stringToPieceMap.put("WR", new Rook(Color.WHITE, "WR"));
	}

	public static Piece getPieceFromString(String input) {
		return stringToPieceMap.get(input);
	}

	/**
	 * private constructor
	 */
	private PieceUtil() {

	}
}
