package mission.red.leetcode;
import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/submissions/
 * 
 * @author sukhwanp
 *
 */
public class MinimumAddParenthesis {

	public int minAddToMakeValid(String word) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == '(') {
				stack.push('(');
			} else if (stack.isEmpty() || stack.peek() != '(') {
				stack.push(')');
			} else {
				stack.pop();
			}
		}
		return stack.size();
	}

	public static void main(String[] args) {
		MinimumAddParenthesis solution = new MinimumAddParenthesis();

		System.out.println(solution.minAddToMakeValid("())"));
	}

}
