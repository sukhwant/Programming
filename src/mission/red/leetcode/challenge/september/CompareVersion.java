package mission.red.leetcode.challenge.september;

public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");

        for (int i = 0; i < Math.max(first.length, second.length); i++) {
            int firstVersion = i < first.length ? Integer.parseInt(first[i]) : 0;
            int secondVersion = i < second.length ? Integer.parseInt(second[i]) : 0;
            if(firstVersion < secondVersion){
                return -1;
            } else if(firstVersion > secondVersion){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.01", version2 = "1.001";

        System.out.println(new CompareVersion().compareVersion(version1, version2));
    }
}
