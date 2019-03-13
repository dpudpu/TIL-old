package algorithm.leetcode;

public class LeetCode300 {
    public static int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
