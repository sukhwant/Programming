package mission.red.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class NumTilesPossibility {

    public static void main(String[] args) {
        System.out.println(new NumTilesPossibility().numTilePossibilities("AAB"));
    }

    private void dfs(String tiles, int count, Set<String> words, char[] currWord,
        boolean[] visited, int currCount) {
        if (currCount == count) {
            //System.out.println(new String(currWord));
            words.add(new String(currWord));
            return;
        }

        //choices
        for (int i = 0; i < tiles.length(); i++) {
            //constraint
            if (!visited[i]) {
                visited[i] = true;
                currWord[currCount++] = tiles.charAt(i);
                dfs(tiles, count, words, currWord, visited, currCount);

                //Backtrack
                visited[i] = false;
                currCount--;
            }
        }

    }

    public int numTilePossibilities(String tiles) {
        Set<String> words = new HashSet<>();
        for (int i = 1; i <= tiles.length(); i++) {
            dfs(tiles, i, words, new char[i], new boolean[tiles.length()], 0);
        }
        System.out.println(words);
        return words.size();
    }
}
