package algorithm.leetcode.dinamic;

public class LeetCode53 {
    public static int maxSubArray(int[] nums) {

        int sum=nums[0];
        int max=nums[0];
        for(int i=1; i<nums.length;i++){
            sum = Math.max(sum+nums[i],nums[i]);
            max = Math.max(sum, max);
        }

//        for (int i = 0; i < nums.length ; i++) {
//            int sum = nums[i];
//            if(sum>max)
//                max=sum;
//            for (int j = i + 1; j < nums.length; j++) {
//                if ((sum += nums[j]) > max)
//                    max = sum;
//            }
//        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(maxSubArray(nums));
    }
}
