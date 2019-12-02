package mission.red.geeksforgeeks.easy;

/**
 * https://www.geeksforgeeks.org/program-to-check-if-a-matrix-is-binary-matrix-or-not/
 * 
 * @author sukhwanp
 *
 */
public class BooleanMatrix {

    public static void main(String[] args) {
        int[][] arr = { { 1, 0, 2, 1 }, { 0, 1, 0, 1 }, { 1, 1, 1, 0 } };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!(arr[i][j] == 0 || arr[i][j] == 1)) {
                    System.out.println("NO!!!");
                    return;
                }
            }
        }
        System.out.println("YES!!!");
    }

}
