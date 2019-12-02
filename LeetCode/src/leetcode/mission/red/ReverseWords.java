package leetcode.mission.red;
import java.util.Stack;

public class ReverseWords {

	public String reverseWords(String input) {

		Stack<String> words = new Stack<>();

		String[] wordList = input.split(" ");

		for (String word : wordList) {
			if (!word.equals(" ") && !word.equals("")) {
				words.push(word);
			}
		}

		StringBuilder answerBuilder = new StringBuilder();
		while (words.size() > 1) {
			answerBuilder.append(words.pop());
			answerBuilder.append(' ');
		}

		if (!words.isEmpty()) {
			answerBuilder.append(words.pop());
		}
		return answerBuilder.toString();
	}

	public static void main(String[] args) {
		ReverseWords reverseWord = new ReverseWords();
		String input = " 1";
		System.out.println(reverseWord.reverseWords(input));

	}

}
