package mission.red.geeksforgeeks.datastructure.stack;

import java.util.Stack;
import java.util.Vector;

/**
 * https://www.geeksforgeeks.org/delete-consecutive-words-sequence/
 * 
 * @author sukhwanp
 *
 */
public class DeleteConsecutiveWords {

    public static void main(String[] args) {
        Vector<String> v = new Vector<>();

        v.addElement("tom");
        v.addElement("jerry");
        v.addElement("jerry");
        v.addElement("tom");

        System.out.println(removeConsecutiveSame(v));
    }

    private static int removeConsecutiveSame(Vector<String> strings) {

        Stack<String> stack = new Stack<>();
        for (String word : strings) {
            if (stack.isEmpty() || !stack.peek().equals(word)) {
                stack.push(word);
            }
        }
        return stack.size();
    }

}
