package mission.red.geeksforgeeks.medium;

/**
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * 
 * @author sukhwanp
 *
 */
public class FibboNacciLogN {

    public static int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] result = new int[2][2];

        int x = mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0];
        int y = mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1];
        int z = mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0];
        int w = mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1];

        result[0][0] = x;
        result[0][1] = y;
        result[1][0] = z;
        result[1][1] = w;

        return result;
    }

    public static int fibbo(int n) {
        int[][] fibboMat = { { 1, 1 }, { 1, 0 } };
        int[][] result = fibboMat;

        for (int i = 0; i < n; i++) {
            result = multiply(result, fibboMat);
        }
        return result[0][0];
    }

    public static void main(String[] args) {
        System.out.println(fibbo(3));
    }

}
