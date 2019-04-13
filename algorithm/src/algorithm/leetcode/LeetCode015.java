package algorithm.leetcode;

import java.util.List;

/*-
ㄴㅁ아ㅓㄴ
 ㅇㄴㅁ
   ㅇㄴㅁ

 */
public class LeetCode015 {
    public static List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    public static void main(String[] args) {
        int nums[] = {-1,1,0,0};
        List<List<Integer>> threesum = threeSum(nums);


        for (List list : threesum) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
