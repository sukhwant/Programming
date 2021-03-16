package mission.red.interviewbit;

public class Sqrt {

    public int sqrt(int n) {
        long end = n;
        long start = 1;
        if(n == 0){
            return 0;
        }

        while (start <= end) {
            System.out.println(start + " : " + end);
            if(start +1 == end){
                return (int)start;
            }
            if(start == end){
                return (int) start;
            }
            long mid = (start + end) / 2;
            if (mid * mid == n) {
                return (int) mid;
            } else if (mid * mid > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Sqrt().sqrt(5));
    }

}
