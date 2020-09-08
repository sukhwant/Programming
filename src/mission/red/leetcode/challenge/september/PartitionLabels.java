package mission.red.leetcode.challenge.september;

import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        List<Integer> result = new LinkedList<>();
        int[] lastIndexMapping = new int[30];
        for (int i = 0; i < S.length(); i++) {
            lastIndexMapping[S.charAt(i)- 97] = i;
        }

        int start = 0;
        while(start < S.length()){
            // find partition according to current char....
            int currPartition = lastIndexMapping[S.charAt(start) - 97];
            // Check for valid Partition.
            for (int i = start; i < currPartition; i++) {
                if(lastIndexMapping[S.charAt(i) - 97] > currPartition){
                    currPartition = lastIndexMapping[S.charAt(i) - 97];
                }
            }
            // Found one.
            //System.out.println("Start:" + start + "End: " + (currPartition-1));
            result.add(currPartition - start + 1);
            start = currPartition + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
