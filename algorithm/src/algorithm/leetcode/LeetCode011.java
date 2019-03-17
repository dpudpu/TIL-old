package algorithm.leetcode;

public class LeetCode011 {
    // 2. TWO Pointer
    public static int maxArea(int[] height){
        int max = 0;
        int left = 0;
        int right = height.length-1;

        while(left<right){
            int area;
            int h = right-left;
            if(height[left]>height[right]){
                area = height[right--] * h;
            }else{
                area = height[left++] * h;
            }
            max = Math.max(max, area);
        }

        return max;
    }

    // 1. Brute Force
//    public static int maxArea(int[] height) {
//        int max = 0;
//
//        for (int i = 0; i < height.length-1; i++) {
//            for(int j= i+1; j<height.length; j++){
//                int hei = height[i]<height[j]?height[i]:height[j];
//                int n = j-i;
//                max = Math.max(max, hei*n);
//            }
//        }
//
//        return max;
//    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
