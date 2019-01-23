package algorithm.leetcode.dinamic;

import java.util.Arrays;

/*
https://leetcode.com/problems/minimum-falling-path-sum/
931. Minimum Falling Path Sum
 */
public class MinFallingPathSum {
    public static int minFallingPathSum(int[][] A) {
        int size = A.length;
        int[][] sum = new int[size][size];
        int[] nums = new int[3];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0) {
                    sum[i][j] = A[i][j];
                    continue;
                }
                nums[0] = j != 0 ? sum[i - 1][j - 1] : Integer.MAX_VALUE;
                nums[1] = sum[i - 1][j];
                nums[2] = j != size - 1 ? sum[i - 1][j + 1] : Integer.MAX_VALUE;

                sum[i][j] = A[i][j] + Arrays.stream(nums).min().getAsInt();
            }
        }


        return Arrays.stream(sum[size - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minFallingPathSum(A));
    }
}
