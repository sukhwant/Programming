package mission.red.hackerrank;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Socks {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        Map<Integer, Integer> socksCount = new HashMap<>();
        for (int i: ar) {
            socksCount.merge(i, 1, Integer::sum);
        }
        int count = 0;
        for(Entry<Integer, Integer> entry: socksCount.entrySet()){
            count = count + entry.getValue()/2;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] ar = new int[n];
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        scanner.close();
    }
}
