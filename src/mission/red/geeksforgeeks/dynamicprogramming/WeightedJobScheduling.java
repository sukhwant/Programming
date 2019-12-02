package mission.red.geeksforgeeks.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/weighted-job-scheduling/
 * 
 * @author sukhwanp
 *
 */
public class WeightedJobScheduling {

    private static class Job {

        int endTime;
        int profit;
        int startTime;

        public Job(int startTime, int endTime, int profit) {
            super();
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Job [startTime=" + startTime + ", endTime=" + endTime + ", profit=" + profit + "]";
        }

    }

    private static class SchedulingResult {
        List<Job> jobResult;
        int maxProfit;

        public List<Job> getJobResult() {
            return jobResult;
        }

        public void setJobResult(List<Job> jobResult) {
            this.jobResult = jobResult;
        }

        public int getMaxProfit() {
            return maxProfit;
        }

        public void setMaxProfit(int maxProfit) {
            this.maxProfit = maxProfit;
        }

        public void addJob(Job job) {
            if (jobResult == null) {
                jobResult = new ArrayList<>();
            }
            jobResult.add(job);
        }

        @Override
        public String toString() {
            return "SchedulingResult [jobResult=" + jobResult + ", maxProfit=" + maxProfit + "]";
        }
    }

    private SchedulingResult weightedJobScheduling(Job[] jobs) {

        int[] result = new int[jobs.length];
        int[] jobResult = new int[jobs.length];

        int maxProfit = 0;
        int maxProfitIndex = -1;

        Arrays.sort(jobs, (x, y) -> x.endTime - y.endTime);

        for (int i = 0; i < jobs.length; i++) {
            result[i] = jobs[i].profit;
            jobResult[i] = i;
        }

        for (int i = 0; i < jobs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (!doesJobsOverlap(jobs[i], jobs[j])) {
                    if (result[j] + jobs[i].profit > result[i]) {
                        result[i] = result[j] + jobs[i].profit;
                        jobResult[i] = j;
                    }
                    if (result[i] > maxProfit) {
                        maxProfit = result[i];
                        maxProfitIndex = i;
                    }
                }
            }
        }

        SchedulingResult schedulingResult = new SchedulingResult();
        schedulingResult.setMaxProfit(maxProfit);
        int i = maxProfitIndex;
        while (jobResult[i] != i) {
            schedulingResult.addJob(jobs[i]);
            i = jobResult[i];
        }
        schedulingResult.addJob(jobs[i]);
        return schedulingResult;
    }

    private boolean doesJobsOverlap(Job x, Job y) {
        if (x.startTime > y.startTime && x.startTime < y.endTime) {
            return true;
        } else if (y.startTime > x.startTime && y.startTime < x.endTime) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Job[] jobs = new Job[4];
        jobs[0] = new Job(3, 10, 20);
        jobs[1] = new Job(1, 2, 50);
        jobs[2] = new Job(6, 19, 100);
        jobs[3] = new Job(2, 100, 200);

        WeightedJobScheduling jobScheduling = new WeightedJobScheduling();
        System.out.println(jobScheduling.weightedJobScheduling(jobs));
    }
}
