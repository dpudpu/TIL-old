package algorithm.backjoon.bruteforce;

import java.util.Scanner;

public class Quiz2231 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        bruteforce(num);
    }

    private static void bruteforce(int num) {
        int cons=0;
        //54 이유 모든 자리숫자가 999999인 경우가 모든 자리수의 합이 가장 큼
        for(int i=num;i>num-54&&i>0;i--){
            int n=i;
            int sum=i;
            while(n!=0){
                sum+=n%10;
                n/=10;
            }
            if(sum==num)
                cons = i;
        }
        System.out.println(cons);
    }
}
