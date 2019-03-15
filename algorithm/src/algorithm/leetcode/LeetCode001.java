package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode001 {
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];

            if (map.containsKey(value)) {
                answer[1] = i;
                answer[0] = map.get(value);
                break;
            }
            map.put(nums[i], i);
        }

//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (target == nums[i] + nums[j]) {
//                    answer[0] = i;
//                    answer[1] = j;
//                }
//            }
//        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        for (int num : twoSum(nums, 6))
            System.out.println(num);
    }
}
