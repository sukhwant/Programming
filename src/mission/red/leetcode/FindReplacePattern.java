package mission.red.leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-and-replace-pattern/submissions/
 * 
 * @author sukhwanp
 *
 */
public class FindReplacePattern {

	private boolean match(String word, String pattern) {

		Map<Character, Character> m1 = new HashMap<>();
		Map<Character, Character> m2 = new HashMap<>();

		for (int i = 0; i < word.length(); ++i) {

			char w = word.charAt(i);
			char p = pattern.charAt(i);

			if (!m1.containsKey(w))
				m1.put(w, p);
			if (!m2.containsKey(p))
				m2.put(p, w);

			if (m1.get(w) != p || m2.get(p) != w)
				return false;
		}

		return true;
	}

	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> result = new ArrayList<>();
		for (String word : words) {
			if (match(word, pattern)) {
				result.add(word);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
