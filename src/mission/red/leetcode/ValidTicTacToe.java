package mission.red.leetcode;
import java.util.LinkedList;
import java.util.List;

public class ValidTicTacToe {

    public boolean validTicTacToe(String[] board) {
        List<Integer> xLocation = getLocation(board, 'X');
        List<Integer> oLocation = getLocation(board, 'O');
        boolean[] visited = new boolean[10];

        return isValid(xLocation, oLocation, visited, 'X');
    }

    private boolean isValid(List<Integer> xLocation, List<Integer> oLocation, boolean[] visited,
            Character turn) {

        boolean isValid = false;
        if (turn == 'X') {
            boolean isASlotEmpty = false;
            for (Integer slot : xLocation) {
                if (!visited[slot]) {
                    isASlotEmpty = true;
                    // visit it
                    System.out.println("Turn X, Selecting slot - " + slot);
                    visited[slot] = true;
                    // Search for solution...
                    boolean tempAns = isValid(xLocation, oLocation, visited, 'O');
                    isValid = isValid || tempAns;
                    visited[slot] = false;
                }
            }
            if (!isASlotEmpty) {
                return true;
            }
        } else {
            boolean isASlotEmpty = false;
            for (Integer slot : oLocation) {
                if (!visited[slot]) {
                    isASlotEmpty = true;
                    // visit it
                    System.out.println("Turn O, Selecting slot - " + slot);
                    visited[slot] = true;
                    // Search for solution...
                    boolean tempAns = isValid(xLocation, oLocation, visited, 'X');
                    isValid = isValid || tempAns;
                    visited[slot] = false;
                }
            }
            if (!isASlotEmpty) {
                return true;
            }

        }
        return isValid;
    }

    private List<Integer> getLocation(String[] board, char ch) {
        int start = 1;
        List<Integer> result = new LinkedList<>();
        for (String row : board) {
            for (int index = 0; index < row.length(); index++) {
                if (row.charAt(index) == ch) {
                    result.add(start);
                }
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] input = { "XXX", "   ", "OOO" };

        System.out.println(new ValidTicTacToe().validTicTacToe(input));

    }

}
