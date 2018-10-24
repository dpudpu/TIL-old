package algorithm.backjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plus123 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(br.readLine());

        int[] nums = new int[max];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if(nums[i]<1 || nums[i]>10) {
                i--;
                System.out.println("다시 입력");
            }
        }
        for (int num : nums)
            System.out.println(solution(num));
    }

    private static int solution(int num) {
        if (num == 1)
            return 1;
        else if (num == 2)
            return 2;
        else if (num == 3)
            return 4;
        return solution(num - 1) + solution(num - 2) + solution(num - 3);
    }
}
