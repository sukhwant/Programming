package mission.red.leetcode;

/**
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 * 
 * @author sukhwanp
 *
 */
public class MaxDistanceClosestPerson {

    public int maxDistToClosest(int[] seats) {

        int left = 0;
        int right = 0;
        int maxDistance = 0;

        while (right < seats.length) {
            left = right;
            while (left < seats.length && seats[left] == 1) {
                left++;
            }
            right = left;
            while (right < seats.length && seats[right] == 0) {
                right++;
            }
            maxDistance = Math.max(maxDistance, (right - left + 1) / 2);

            if ((right == seats.length && seats[right - 1] == 0)
                    || (left == 0 && seats[left] == 0)) {
                maxDistance = Math.max(right - left, maxDistance);
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        int[] input = {1, 0, 0, 0};
        System.out.println(new MaxDistanceClosestPerson().maxDistToClosest(input));
    }

}
