package mission.red.geeksforgeeks.datastructure.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/merging-intervals/
 * 
 * @author sukhwanp
 *
 */
public class MergeOverlappingIntervals {

    private static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static List<Event> merge(Event[] input) {
        Arrays.sort(input, (x, y) -> x.start - y.start);
        List<Event> result = new LinkedList<>();

        Event current = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i].start > current.end) {
                // System.out.println("Cannot merge. Event starting after this.");
                result.add(current);
                current = input[i];
            } else {
                if (input[i].end <= current.end) {
                    // System.out.println("Non need to merge. Event ending earlier or at same
                    // time");
                } else if (input[i].end > current.end) {
                    // System.out.println("Merge....");
                    current.end = input[i].end;
                } else {
                    // System.out.println("Cannot happen..........");
                }
            }
        }
        result.add(current);
        return result;

    }

    public static void main(String[] args) {

        int t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while (t-- > 0) {
            int n;
            n = scanner.nextInt();
            Event[] events = new Event[n];
            for (int i = 0; i < n; i++) {
                events[i] = new Event(scanner.nextInt(), scanner.nextInt());
            }
            List<Event> result = merge(events);

            for (Event event : result) {
                System.out.print(event.start + " " + event.end + " ");
            }
            System.out.println();
        }
    }

}
