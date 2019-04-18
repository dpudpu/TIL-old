package algorithm.leetcode.etc;

public class LC033 {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return -1;

        for(int i=0; i<n;i++){
            if(nums[i] == target)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(search(nums, 0));
        System.out.println(search(nums, 3));
        System.out.println(search(new int[]{}, 3));
        System.out.println(search(new int[]{1,3}, 1));
    }
}
