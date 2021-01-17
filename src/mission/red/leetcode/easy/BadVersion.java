package mission.red.leetcode.easy;


// TODO:
public class BadVersion {

    boolean isBadVersion(int version){
        return version == 5;
    }

    boolean binarySearch(int n, int max){
        if(n < 0 || n > max){
            return true;
        }

        if(isBadVersion(n)){
            return true;
        }

        return false;
    }

    public int firstBadVersion(int n) {

        return -1;
    }

}
