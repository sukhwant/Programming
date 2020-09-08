package mission.red.leetcode.challenge.september;

import java.util.Arrays;

public class LargestTime {

    public String largestTimeFromDigits(int[] A) {

        int[] isPresent = new int[11];
        Arrays.fill(isPresent, 0);

        for (int i = 0; i < A.length; i++) {
            isPresent[A[i]] = isPresent[i] + 1;
        }

        int hour1, hour2, min1, min2;

        // Search for Hour...
        if(isPresent[2] > 0){
            hour1 = 2;
            isPresent[2]--;

            // Search for second hour
            if(isPresent[3] > 0){
                hour2 = 3;
                isPresent[3]--;
            } else if(isPresent[2] > 0){
                hour2 = 2;
                isPresent[2]--;
            } else if (isPresent[1] > 0){
                hour2 = 1;
                isPresent[1]--;
            } else if(isPresent[0] > 0){
                hour2 = 0;
                isPresent[0]--;
            } else{
                return "";
            }

        } else if(isPresent[1] > 0){
            hour1 = 1;
            isPresent[1]--;

            if(isPresent[9] > 0){
                hour2 = 9;
                isPresent[9]--;
            } else if(isPresent[8] > 0){
                hour2 = 8;
                isPresent[8]--;
            } else if (isPresent[7] > 0){
                hour2 = 7;
                isPresent[7]--;
            } else if(isPresent[6] > 0){
                hour2 = 6;
                isPresent[6]--;
            }else if(isPresent[5] > 0){
                hour2 = 5;
                isPresent[5]--;
            } else if(isPresent[4] > 0){
                hour2 = 4;
                isPresent[4]--;
            } else if (isPresent[3] > 0){
                hour2 = 3;
                isPresent[3]--;
            } else if(isPresent[2] > 0){
                hour2 = 2;
                isPresent[2]--;
            } else if (isPresent[1] > 0){
                hour2 = 1;
                isPresent[1]--;
            } else if(isPresent[0] > 0){
                hour2 = 0;
                isPresent[0]--;
            } else{
                return "";
            }
        } else if(isPresent[0] > 0){
            hour1 = 0;
            isPresent[0]--;

            if(isPresent[9] > 0){
                hour2 = 9;
                isPresent[9]--;
            } else if(isPresent[8] > 0){
                hour2 = 8;
                isPresent[8]--;
            } else if (isPresent[7] > 0){
                hour2 = 7;
                isPresent[7]--;
            } else if(isPresent[6] > 0){
                hour2 = 6;
                isPresent[6]--;
            }else if(isPresent[5] > 0){
                hour2 = 5;
                isPresent[5]--;
            } else if(isPresent[4] > 0){
                hour2 = 4;
                isPresent[4]--;
            } else if (isPresent[3] > 0){
                hour2 = 3;
                isPresent[3]--;
            } else if(isPresent[2] > 0){
                hour2 = 2;
                isPresent[2]--;
            } else if (isPresent[1] > 0){
                hour2 = 1;
                isPresent[1]--;
            } else if(isPresent[0] > 0){
                hour2 = 0;
                isPresent[0]--;
            } else{
                return "";
            }
        } else{
            return "";
        }

        // Select Min.
        int num1 = -1, num2 = -1;
        for (int i = 0; i < 10; i++) {
            if(isPresent[i] > 0){
                if(num1 == -1)
                    num1 = i;
                else
                    num2 = i;
            }
        }
        if(num1 == -1 && num2 == -1){
            return "";
        } else{
            if(num1 > num2){
                return hour1+hour2 +":" + num1+num2;
            }
            return "" + hour1+""+hour2 +":" + num2+""+num1;
        }
    }

    public static void main(String[] args) {
        int[] input = {0,0,1,0};

        System.out.println(new LargestTime().largestTimeFromDigits(input));

    }
}
