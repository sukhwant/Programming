package mission.red.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class NumTilesPossibility {

    public static void main(String[] args) {
        System.out.println(new NumTilesPossibility().numTilePossibilities("AAB"));
    }

    private void dfs(String tiles, int count, Set<String> words) {

    }

    public int numTilePossibilities(String tiles) {
        Set<String> words = new HashSet<>();
        for (int i = 1; i < tiles.length(); i++) {
            dfs(tiles, i, words);
        }
    }
}
