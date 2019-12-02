package mission.red.geeksforgeeks.greedy;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
 * 
 * @author sukhwanp
 *
 */
public class ActivitySelection {

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Activity {
        private int startTime;
        private int finishTime;
    }

    public static void main(String[] args) {

        List<Activity> activities = new LinkedList<>();
        activities.add(new Activity(1, 2));
        activities.add(new Activity(3, 4));
        activities.add(new Activity(0, 6));
        activities.add(new Activity(5, 7));
        activities.add(new Activity(8, 9));
        activities.add(new Activity(5, 9));
        maxActivities(activities);
    }

    private static int maxActivities(List<Activity> activities) {
        activities.sort((x, y) -> x.finishTime - y.finishTime);

        Activity previous = activities.get(0);
        int count = 1;
        System.out.println("Picking first activity with startTime as - " + previous.getStartTime() + " FinishTIme:- "
                + previous.getFinishTime());
        for (Activity activity : activities) {
            if (activity.startTime >= previous.getFinishTime()) {
                // Pick it
                previous = activity;
                count++;
                System.out.println("Picking first activity with startTime as - " + previous.getStartTime()
                        + " FinishTIme:- " + previous.getFinishTime());
            }
        }
        return count;
    }
}
