package mission.red.leetcode.challenge.feburary;

public class HammingDistance {

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n = n & (n - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingWeight(11));
    }
}
