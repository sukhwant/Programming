package mission.red.leetcode.medium;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 * 
 * https://leetcode.com/problems/the-skyline-problem/discuss/61264/easy-to-understand-O(nlogn)-java-solution-with-detailed-explanation
 * 
 * @author sukhwanp
 *
 */
public class SkyLine {

    public class Point {
        int start;
        int end;
        int height;

        boolean isStart;

        public Point(int start, int end, int height, boolean isStart) {
            super();
            this.start = start;
            this.end = end;
            this.height = height;
            this.isStart = isStart;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        // Step 1. Construct Points.

        List<Point> points = new LinkedList<>();
        for (int i = 0; i < buildings.length; i++) {
            points.add(new Point(buildings[i][0], buildings[i][1], buildings[i][2], true));
            points.add(new Point(buildings[i][1], buildings[i][1], buildings[i][2], false));
        }

        // Step 2.
        points.sort(this::pointComparator);

        // Step 3.

        PriorityQueue<Point> maxHeap = new PriorityQueue<>(this::heapComparator);

        List<int[]> result = new LinkedList<int[]>();
        int prevHeight = 0;
        for (Point point : points) {

            if (point.isStart) {
                maxHeap.offer(point);
            }

            while (!maxHeap.isEmpty() && maxHeap.peek().end <= point.start) {
                maxHeap.poll();
            }

            int currMaxHeight = maxHeap.isEmpty() ? 0 : maxHeap.peek().height;

            if (prevHeight != currMaxHeight) {
                result.add(new int[] { point.start, currMaxHeight });
            }
            prevHeight = currMaxHeight;
        }
        return result;
    }

    int heapComparator(Point x, Point y) {
        return Integer.compare(x.height, y.height);
    }

    int pointComparator(Point x, Point y) {
        if (x.start != y.start) {
            return Integer.compare(x.start, y.start);
        } else {
            if (x.isStart && y.isStart) {
                return Integer.compare(x.height, y.height);
            } else {
                return x.isStart ? -1 : 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 },
                { 19, 24, 8 } };
        List<int[]> result = new SkyLine().getSkyline(buildings);
        System.out.println("Hello world");
    }

}
