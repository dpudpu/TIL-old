package algorithm.leetcode.binarySearch;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Quiz287 {
    public static int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5);
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;

//        Set set = new HashSet();
//        for(int num : nums){
//            if(set.contains(num))
//                return num;
//            set.add(num);
//        }
//        return -1;

//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++)
//            if (nums[i] == nums[i + 1]) return nums[i];
//        return -1;


//        for (int i = 0; i < nums.length; i++)
//            for (int j = i + 1; j < nums.length; j++)
//                if (nums[i] == nums[j])
//                    return nums[i];
//        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }
}
