package mission.red.leetcode.medium;

public class SoupServing {

    public static double result = 0;
    public void dfs(int a, int b, int step){
        if(a == 0 && b == 0){
            result = result + (step * 0.25)/2;
            return; // both same time.
        } else if(a == 0){
            result = result + (step * 0.25);
            return; // A empty first

        }

        dfs(Integer.max(a-100, 0), b, step+1);
        dfs(Integer.max(a-75,0), Integer.max(b-25,0), step+1);
        dfs(Integer.max(a-50,0), Integer.max(b-50,0), step+1);
        dfs(Integer.max(a-25,0), Integer.max(b-75,0), step+1);
    }

    public double soupServings(int N) {
        dfs(N, N, 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new SoupServing().soupServings(50));
    }
}
