package mission.red.geeksforgeeks.greedy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * https://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/
 * 
 * @author sukhwanp
 *
 */
public class GreedyAlgorithm {

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Job {
        private String id;
        private int deadline;
        private int profit;
    }

    public static void maxProfit(List<Job> jobs) {

        Set<Integer> slotSet = new HashSet<>();
        jobs.sort((x, y) -> y.getProfit() - x.getProfit());

        for (Job job : jobs) {
            for (int i = 1; i <= job.deadline; i++) {
                if (!slotSet.contains(i)) {
                    slotSet.add(i);
                    System.out.println("Picking Job " + job.getId() + " with profit " + job.getProfit()
                            + " and with deadline " + job.getDeadline());
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        List<Job> jobs = new LinkedList<>();
        jobs.add(new Job("a", 2, 100));
        jobs.add(new Job("b", 1, 19));
        jobs.add(new Job("c", 2, 27));
        jobs.add(new Job("d", 1, 25));
        jobs.add(new Job("e", 3, 15));

        maxProfit(jobs);
    }

}
