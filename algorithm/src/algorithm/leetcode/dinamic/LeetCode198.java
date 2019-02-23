package algorithm.leetcode.dinamic;


public class LeetCode198 {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;

        int prev1=0;
        int prev2=0;
        for(int num :nums){
            int tmp = prev2;
            prev2 = Math.max(prev2, prev1+num);
            prev1 = tmp;
        }
        return Math.max(prev1,prev2);
    }



    public static void main(String[] args) {
        int nums[] = {2, 7, 9, 3, 6,3};
        LeetCode198 leetCode198 = new LeetCode198();
        System.out.println(leetCode198.rob(nums));
    }
}
