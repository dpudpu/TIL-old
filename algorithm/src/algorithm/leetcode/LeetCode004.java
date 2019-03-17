package algorithm.leetcode;

public class LeetCode004 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double answer = 0;
        int nums[] = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int mid = (length1 + length2 - 1) / 2;

        int i = 0;
        while (p1 < length1 && p2 < length2 && i <= mid + 1) {

            if (nums1[p1] < nums2[p2]) {
                nums[i] = nums1[p1++];
            } else if (nums1[p1] == nums2[p2]) {
                nums[i] = nums1[p1++];
                nums[i + 1] = nums2[p2++];
                i++;
            } else {
                nums[i] = nums2[p2++];
            }
            i++;
        }

        while (p1 < length1 && i <= mid + 1) {
            nums[i++] = nums1[p1++];
        }
        while (p2 < length2 && i <= mid + 1) {
            nums[i++] = nums2[p2++];
        }


        if ((double) (length1 + length2 - 1) / 2 % 1 == 0.5) {
            answer = (double) (nums[mid] + nums[mid + 1]) / 2;
        } else
            answer = nums[mid];

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2, 3, 4}; // 5
        int[] nums2 = {5, 6, 7}; // 3 3,4

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
