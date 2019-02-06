package algorithm.leetcode.binarySearch;

public class BinaryExam {
    public static int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;

        if (nums[mid] == target)
            return mid;
        else if (nums[mid] > target)
            return binarySearch(nums, target, start, mid - 1);
        else
            return binarySearch(nums, target, mid+1, end);
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 6, 8, 10};
        System.out.println(binarySearch(nums, 8, 0, nums.length - 1));
    }
}
