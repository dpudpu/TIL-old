package algorithm.leetcode.dinamic;

public class LeetCode303 {
    int sum[];
    public LeetCode303(int[] nums) {
        int n = nums.length;
        sum = new int[n+1];
        for(int i=0;i<n;i++){
            sum[i+1] = sum[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }

    public static void main(String[] args) {
        int nums[] = {-2, 0, 3, -5, 2, -1};
        LeetCode303 leetCode303 = new LeetCode303(nums);
        System.out.println(leetCode303.sumRange(2, 5));

    }
}
