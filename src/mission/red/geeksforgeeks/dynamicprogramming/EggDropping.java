package mission.red.geeksforgeeks.dynamicprogramming;

public class EggDropping {

    private static int eggDropping(int numberOfEggs, int numberOfFloors) {

        int[][] table = new int[numberOfEggs + 1][numberOfFloors + 1];

        // We need one trial for one floor and0 trials for 0 floors
        for (int i = 1; i <= numberOfEggs; i++) {
            table[i][1] = 1;
            table[i][0] = 0;
        }

        // We always need j trials for one egg and j floors.
        for (int j = 1; j <= numberOfFloors; j++) {
            table[1][j] = j;
        }

        for (int egg = 2; egg <= numberOfEggs; egg++) {
            for (int floor = 2; floor <= numberOfFloors; floor++) {
                // System.out.println("Calculating for floor- " + floor + " with eggs- " + egg);
                table[egg][floor] = Integer.MAX_VALUE;
                for (int x = 1; x <= floor; x++) {
                    int temp = 1 + Math.max(table[egg - 1][x - 1], table[egg][floor - x]);
                    // System.out.println("temp- " + temp);
                    table[egg][floor] = Math.min(table[egg][floor], temp);
                }
            }

        }
        return table[numberOfEggs][numberOfFloors];
    }

    private static int divideAndConqur(int n) {
        // System.out.println("n:- " + n);
        int ans;
        if (n == 1) {
            ans = 0;
        } else {
            int blockSize = (int) Math.sqrt(n);
            // System.out.println("blockSize- " + blockSize);
            ans = divideAndConqur(blockSize) + (int) n / blockSize;
        }
        // System.out.println("Answer for n- " + n + " is- "+ ans);
        return ans;
    }

    public static void main(String[] args) {
        for (int i = 2; i < 2000; i++) {
            System.out.println(i + " " + eggDropping(2000, i) + " " + divideAndConqur(i));
        }
    }

}
