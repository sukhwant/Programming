package flipkart.interview.chess.model;

public class Tester {

	public static void main(String[] args) {
		Chess chess = new Chess(initializeChess());
		chess.print();

		System.out.println();
		chess.move("WP", "12", "22");
		chess.print();
		chess.move("WR", "10", "30");
		chess.print();

		chess.move("WR", "30", "35");
		chess.print();

//		chess.move("WR", "35", "65");
//		chess.print();
		
		chess.move("BP", "65", "55");
		chess.print();
		
		chess.move("BP", "64", "54");
		chess.print();
		
		chess.move("BP", "54", "44");
		chess.print();
		
		chess.move("BP", "44", "35");
		chess.print();
	}

	private static String[][] initializeChess() {
		String[][] input = { 
				{ "WP", "WP", "WP", "WP", "WP", "WP", "WP", "WP" },
				{ "WR", "WP", "WP", "WP", "WP", "WP", "WP", "WP" }, 
				{ "--", "--", "--", "--", "--", "--", "--", "--" },
				{ "--", "--", "--", "--", "--", "--", "--", "--" }, 
				{ "--", "--", "--", "--", "--", "--", "--", "--" },
				{ "--", "--", "--", "--", "--", "--", "--", "--" }, 
				{ "BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP" },
				{ "BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP" } 
				};
		return input;
	}
}
