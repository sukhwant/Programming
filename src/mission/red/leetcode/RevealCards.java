package mission.red.leetcode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/discuss/201469/Java-MOST-straight-forward-solution-5-ms-beats-100
 * 
 * @author sukhwanp
 *
 */
public class RevealCards {

	public int[] deckRevealedIncreasing(int[] deck) {

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < deck.length; i++) {
			queue.add(i);
		}

		int[] order = new int[deck.length];

		for (int i = 0; i < deck.length; i++) {
			order[i] = queue.poll();

			if (i < deck.length) {
				queue.add(queue.poll());
			}
		}

		Arrays.sort(deck);
		int[] result = new int[deck.length];
		for (int i = 0; i < deck.length; i++) {
			result[order[i]] = deck[i];
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = { 17, 13, 11, 2, 3, 5, 7 };
		new RevealCards().deckRevealedIncreasing(input);
	}

}
