package algorithm.leetcode;

import java.util.Arrays;

public class LeetCode016 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];


        for (int i = 0; i < nums.length - 2; i++) {
            int l = i+1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l]+nums[r];
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
                closestSum = Math.abs(target - closestSum) < Math.abs(target - sum) ? closestSum : sum;
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
