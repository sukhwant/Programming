package mission.red.geeksforgeeks.easy;

/**
 * 
 * @author sukhwanp
 *         https://www.geeksforgeeks.org/check-if-it-is-possible-to-move-from-0-0-to-x-y-in-n-steps/
 * 
 */
public class CheckMoveToXY {

    public static void main(String[] args) {
        int x = 2;
        int y = 2;
        int n = 1;

        int minMoves = Math.abs(x) + Math.abs(y);
        int remainingMoves = n - minMoves;

        if (remainingMoves % 2 == 0) {
            System.out.println("YES.");
            return;
        }

        System.out.println("NO!!!");
    }

}
