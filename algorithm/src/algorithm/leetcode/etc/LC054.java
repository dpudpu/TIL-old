package algorithm.leetcode.etc;

import java.util.ArrayList;
import java.util.List;

public class LC054 {

    public static final String BOTTOM = "BOTTOM";
    public static final String RIGHT = "RIGHT";
    public static final String LEFT = "LEFT";
    public static final String TOP = "TOP";

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0)
            return result;

        int row = matrix.length;
        int col = matrix[0].length;

        int r = 0;
        int c = 0;
        int left = 0;
        int right = col - 1;
        int top = 1;
        int bottom = row - 1;

        String command = col == 1 ? BOTTOM : RIGHT;


        int cnt = row * col;
        while (cnt-- > 0) {
            result.add(matrix[r][c]);

            switch (command) {
                case RIGHT:
                    if (++c == right) {
                        command = BOTTOM;
                        right--;
                    }
                    break;
                case LEFT:
                    if (--c == left) {
                        command = TOP;
                        left++;
                    }
                    break;
                case TOP:
                    if (--r == top) {
                        command = RIGHT;
                        top++;
                    }
                    break;
                case BOTTOM:
                    if (++r == bottom) {
                        command = LEFT;
                        bottom--;
                    }
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };


//        System.out.println(spiralOrder(matrix).toString());

        int[][] matrix1 = {{1}, {2}};
        System.out.println(spiralOrder(matrix1).toString());
    }
}
