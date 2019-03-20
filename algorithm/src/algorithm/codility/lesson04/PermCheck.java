package algorithm.codility.lesson04;

import java.util.Arrays;

public class PermCheck {
    public static int solution(int nums[]) {
        Arrays.sort(nums);

        int num=1;

        for (int i = 0; i < nums.length; i++) {
            if (num != nums[i])
                return 0;
            num++;
        }
        return 1;
    }

    public static void main(String[] args) {
        int nums[] = {2};
        System.out.println(solution(nums));
    }
}
