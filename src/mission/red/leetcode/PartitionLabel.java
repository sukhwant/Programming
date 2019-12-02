package mission.red.leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/partition-labels/submissions/
 * 
 * @author sukhwanp
 *
 */
public class PartitionLabel {

	public static List<Integer> partitionLabels(String input) {
		List<Integer> result = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < input.length(); i++) {
			map.put(input.charAt(i), i);
		}

		int currentStart = 0;
		int currentEnd = 0;
		int currLengthStart = 0;

		while (currentEnd < input.length() && currentStart <= input.length()) {
			// System.out.println("CurrentStart: " + currentStart + " CurrentEnd: " +
			// currentEnd);
			if (currentStart > currentEnd) {
				// System.out.println("Start new string...." + (currentEnd - currLengthStart +
				// 1));
				result.add(currentEnd - currLengthStart + 1);
				currLengthStart = currentStart;

			}
			if (currentStart < input.length()) {
				Character currentCharacter = input.charAt(currentStart);
				currentEnd = Math.max(currentEnd, map.get(currentCharacter));
			}
			currentStart++;
		}

		return result;
	}

	public static void main(String[] args) {
		String input = "ababcbacadefegdehijhklij";
		List<Integer> ans = partitionLabels(input);
		System.out.println("hello world");
	}

}
