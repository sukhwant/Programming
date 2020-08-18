package mission.red.leetcode.medium;

public class NumberOfTeam {

    /**
     * O(n^3)
     * @param rating
     * @return
     */
    public int numTeams(int[] rating) {
        int count = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i+1; j < rating.length; j++) {
                for (int k = j+1; k < rating.length; k++) {
                    if(rating[i] > rating[j] && rating[j] > rating[k]){
                        count++;
                    }
                    if(rating[i] < rating[j] && rating[j] < rating[k]){
                        count++;
                    }
                }
            }

        }
        return count;
    }

    /**
     * O(n^2)
     * @param rating
     * @return
     */
    public int numTeams2(int[] rating) {
        int count = 0;
        for (int i = 0; i < rating.length; i++) {
            int leftSmall = 0, leftlarge = 0;
            int rightSmall = 0, rightlarge = 0;

            for (int j = 0; j < i; j++) {
                if(rating[i] > rating[j])
                    leftSmall++;
                if(rating[i] < rating[j])
                    leftlarge++;
            }

            for (int j = i+1; j < rating.length; j++) {
                if(rating[i] > rating[j])
                    rightSmall++;
                if(rating[i] < rating[j])
                    rightlarge++;
            }

            count += leftSmall*rightlarge + leftlarge * rightSmall;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] input = {2,5,3,4,1};
        System.out.println(new NumberOfTeam().numTeams(input));
    }
}
