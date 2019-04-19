package algorithm.leetcode.etc;

import java.util.HashSet;
import java.util.Set;

public class LC036 {
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet();
            Set<Character> colSet = new HashSet();
            Set<Character> boxSet = new HashSet();
            for (int j = 0; j < 9; j++) {
                if (isValid(colSet, board[i][j])) return false;

                if (isValid(rowSet, board[j][i])) return false;

                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                if (isValid(boxSet, board[RowIndex + j / 3][ColIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }

    private static boolean isValid(Set<Character> set, char num) {
        if (num != '.' && !set.add(num))
            return true;
        return false;
    }

//    private static boolean isValidRow(char[][] board) {
//        for (int i = 0; i < board.length; i++) {
//            int cnt = 0;
//            Set<Character> set = new HashSet<>();
//            for(int j=0; j<board.length; j++) {
//                if (board[i][0] != '.')
//            }
//        }
//
//        return true;
//    }
//
//    private static boolean isValidColumn(char[][] board) {
//
//        return true;
//    }
//
//    private static boolean isValidBox(char[][] board) {
//
//        return true;
//    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }
}
