package mission.red.geeksforgeeks.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

/**
 * TODO:-
 * 
 * @author sukhwanp
 *
 */
public class WaterConnection {

    public static void main(String[] args) {
        int numberOfHouses = 9;
        int[][] arr = { { 7, 4, 98 }, { 5, 9, 72 }, { 4, 6, 10 }, { 2, 8, 22 }, { 9, 7, 17 }, { 3, 1, 66 } };
        solve(numberOfHouses, arr);
    }

    private static void solve(int numberOfHouses, int[][] input) {
        Map<Integer, Pair<Integer, Integer>> hashMap = new HashMap<>();

        for (int[] element : input) {
            hashMap.put(element[0], Pair.of(element[1], element[2]));
        }

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numberOfHouses; i++) {
            if (!visited.contains(numberOfHouses)) {
                visited.add(i);
                int curr = i;
                int smallest = curr;
                // while true.....
                while (true) {
                    if (!hashMap.containsKey(hashMap.get(input[curr][0]).getLeft())) {
                        break;
                    } else {
                    }
                    curr = hashMap.get(input[curr][0]).getLeft();
                }
            }
        }

    }

}
