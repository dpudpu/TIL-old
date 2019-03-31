package algorithm.leetcode.etc;

public class LC027 {
    public static int removeElement(int[] nums, int val) {
        int len = 0;

        for (int num : nums) {
            if(num!=val)
                nums[len++] = num;
        }

        return len;
    }
    public static void main(String[] args) {
        int nums[] = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }
}
