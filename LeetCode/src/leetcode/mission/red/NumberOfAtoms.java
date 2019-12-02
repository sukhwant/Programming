package leetcode.mission.red;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/number-of-atoms/solution/
 * TODO:- 
 * @author sukhwanp
 *
 */
public class NumberOfAtoms {

    public class Element {
        String symbol;
        int count;

        public Element(String symbol, int count) {
            this.symbol = symbol;
            this.count = count;
        }

    }

    public void countOfAtoms(String input) {

        Stack<Element> stack = new Stack<>();
        int index = 0;
        while (index < input.length()) {
            if (input.charAt(index) == '(') {
                stack.push(new Element("(", 1));
                index++;
            } else if (input.charAt(index) == ')') {
                List<Element> temp = new ArrayList<>();
                // Get next number
                int number = getNextNumber(input, index + 1);
                int nextIndex = nextLetterIndex(input, index + 1);

                while (!stack.peek().symbol.equals("(")) {
                    Element element = stack.pop();
                    element.count *= number;
                    temp.add(element);
                }
                stack.pop();
                // Add all element to stack again.
                stack.addAll(temp);
                index = nextIndex;
            } else {
                int number = getNextNumber(input, index + 1);
                int nextIndex = nextLetterIndex(input, index + 1);
                String symbol = getSymbol(input, index);
                stack.push(new Element(symbol, number));
                index = nextIndex;
            }
        }
        System.out.println("Hello Worl");
    }

    private String getSymbol(String input, int index) {
        char[] symbol = new char[input.length()];
        int k = 0;
        symbol[k++] = input.charAt(index);
        while (Character.isLowerCase(input.charAt(++index))) {
            symbol[k++] = input.charAt(index);
        }
        return String.valueOf(symbol);
    }

    private int nextLetterIndex(String input, int index) {
        while (Character.isLowerCase(input.charAt(index))
                || Character.isDigit(input.charAt(index))) {
            index++;
        }
        return index;
    }

    private int getNextNumber(String input, int index) {
        int number = 0;
        while (Character.isDigit(input.charAt(index))) {
            number = number * 10 + Character.getNumericValue(input.charAt(index));
            index++;
        }
        return number == 0 ? 1 : number;
    }

    public static void main(String[] args) {
        String input = "K4(ON(SO3)2)2";
        new NumberOfAtoms().countOfAtoms(input);
    }

}
