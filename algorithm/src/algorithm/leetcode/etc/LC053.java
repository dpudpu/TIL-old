package algorithm.leetcode.etc;

public class LC053 {
    public static int maxSubArray(int[] nums) {
        int largestSum = nums[0];
        int sum = 0;

        for (int num : nums) {
            sum = sum < 0 ? num : num + sum;
            largestSum = Math.max(largestSum, sum);
        }

        return largestSum;
    }

    public static void main(String[] args) {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int nums[] = {-1};
        System.out.println(maxSubArray(nums));
    }
}
