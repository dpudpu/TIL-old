package algorithm.leetcode.binarySearch;

public class Quiz167 {
    public static int[] twoSum(int[] numbers, int target) {
        int end = numbers.length - 1;
        int start = 0;
        int answer[] = new int[2];

        while (start < end) {
            int result = numbers[start] + numbers[end];
            if (result == target) {
                answer[0] = start + 1;
                answer[1] = end + 1;
                break;
            } else if (result < target) {
                start++;
            } else {
                end--;
            }
        }

        return answer;
    }


    public static void main(String args[]) {
        int nums[] = {2, 3, 4};
        int answer[] = twoSum(nums, 6);
        System.out.println(answer[0] + ", " + answer[1]);
    }
}
