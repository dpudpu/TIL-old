package algorithm.leetcode.dinamic;

public class Quiz64 {
        public static int minPathSum(int[][] grid) {
        int size = grid.length;
        int size2 = grid[0].length;
        int[][] sum = new int[size][size2];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size2; j++) {
                if (i == 0 && j == 0) {
                    sum[i][j] = grid[i][j];
                    continue;
                } else if (i == 0) {
                    sum[i][j] = grid[i][j] + sum[i][j - 1];
                    continue;
                } else if (j == 0) {
                    sum[i][j] = grid[i][j] + sum[i - 1][j];
                    continue;
                }
                sum[i][j] = grid[i][j] + Math.min(sum[i - 1][j], sum[i][j - 1]);
            }
        }
        return sum[size - 1][size2 - 1];
    }

    public static void main(String[] args) {
//        int[][] grid = {{1,2,5}, {3,2,1}};
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
