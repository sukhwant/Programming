package mission.red.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

    public static boolean isNumeric(char ch){
        return (ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9');
    }

    public boolean isValidSudoku(char[][] board) {

        // Check for Row.
        for (int row = 0; row < board.length; row++) {
            Map<Character, Boolean> isPresent = new HashMap<>();
            for(int col=0; col< board.length; col++){
                if(isNumeric(board[row][col])) {
                    if(isPresent.containsKey(board[row][col])){
                        return false;
                    } else{
                        isPresent.put(board[row][col], true);
                    }
                }
            }
        }

        // Check for Col.
        for (int col = 0; col < board.length; col++) {
            Map<Character, Boolean> isPresent = new HashMap<>();
            for(int row=0; row< board.length; row++){
                if(isNumeric(board[row][col])) {
                    if(isPresent.containsKey(board[row][col])){
                        return false;
                    } else{
                        isPresent.put(board[row][col], true);
                    }
                }
            }
        }

        // Check for Sub Square
        for (int i = 0; i < 7; i = i + 3) {
            for (int j = 0; j < 7; j = j + 3) {
                if(!inValidBox(i, j, board))
                    return false;
            }
        }
        return true;
    }

    private boolean inValidBox(final int startRow, final int startCol, final char[][] board) {
        Map<Character, Boolean> isPresent = new HashMap<>();
        for(int i = startRow; i< startRow + 3;i++){
            for (int j = startCol; j < startCol + 3; j++) {
                if(isNumeric(board[i][j])) {
                    if(isPresent.containsKey(board[i][j])){
                        return false;
                    } else{
                        isPresent.put(board[i][j], true);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] input = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(new ValidSudoku().isValidSudoku(input));
    }
}
