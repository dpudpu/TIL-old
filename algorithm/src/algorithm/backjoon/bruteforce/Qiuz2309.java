package algorithm.backjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Qiuz2309 {
    public static int[] solution(int[] nums, int sum){

        loop:for(int i=0;i<nums.length-1;i++){
            for(int j=1; j<nums.length;j++) {
                int sum1=sum;
                if(!(i==j))
                    sum1-= nums[j]+nums[i];
                if(sum1==100) {
                    nums[i] = 100;
                    nums[j] = 100;
                    break loop;
                }
            }
        }

        Arrays.sort(nums);

        return nums;
    }


    public static void main(String args[]){
        int[] nums = new int[9];
        Scanner sc = new Scanner(System.in);

        int sum=0;
        for(int i=0;i<nums.length;i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        nums = solution(nums,sum);
        for(int i=0;i<7;i++)
            System.out.println(nums[i]);
    }
}
