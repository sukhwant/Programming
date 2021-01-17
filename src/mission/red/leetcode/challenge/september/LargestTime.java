package mission.red.leetcode.challenge.september;

// TODO:
public class LargestTime {

    public String largestTimeFromDigits(int[] A) {

        int maxHr = -1;
        int hr1 = -1, hr2 = -1;
        boolean found = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i != j) {
                    int temp = A[i] * 10 + A[j];
                    if (temp <= 23) {
                        System.out.println(i + "===" + j);
                        System.out.println("Temp is " + temp);
                        if(temp > maxHr) {
                            found = true;
                            maxHr = temp;
                            hr1 = i;
                            hr2 = j;
                        }
                    }
                }
            }
        }
        if(!found)
            return "";

        found = false;

        System.out.println("MaxTiem : " + maxHr);
        System.out.println(hr1 + ":" + hr2);
        int maxMin = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i != j) {
                    if ((i != hr1) && (i != hr2) && (j != hr1) && (j != hr2)) {
                        System.out.println(i + ":" +j);
                        int temp = A[i] * 10 + A[j];
                        System.out.println("Temp is :" + temp);
                        if (temp <= 59) {
                            System.out.println(i + "===" + j);
                            System.out.println("Temp is " + temp);
                            if(temp > maxMin) {
                                found = true;
                                maxMin = temp;
                            }
                        }
                    }
                }
            }
        }

        if(!found)
            return "";

        return "" + (maxHr/10 == 0? ("0" + maxHr): maxHr) + ":" + (maxMin/10 == 0? ("0" + maxMin):
            maxMin);

    }

    public static void main(String[] args) {
        int[] input = {2,0,6,6};

        System.out.println(new LargestTime().largestTimeFromDigits(input));

    }
}
