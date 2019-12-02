package mission.red.geeksforgeeks.greedy;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * https://www.geeksforgeeks.org/job-sequencing-problem-loss-minimization/
 * 
 * @author sukhwanp
 *
 */
public class JobSequenceLossMinimize {

    @Setter
    @Getter
    @AllArgsConstructor
    @ToString
    public static class Job {
        private String id;
        private int loss;
        private int day;
    }

    public static void lossMinimize(List<Job> jobs) {
        jobs.sort((y, x) -> x.loss * y.day - y.loss * x.day);
        jobs.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Job> jobs = new LinkedList<>();
        jobs.add(new Job("1", 1, 2));
        jobs.add(new Job("2", 2, 4));
        jobs.add(new Job("3", 3, 1));
        jobs.add(new Job("4", 5, 3));
        jobs.add(new Job("5", 6, 2));

        lossMinimize(jobs);
    }

}
