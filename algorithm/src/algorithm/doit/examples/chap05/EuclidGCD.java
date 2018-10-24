package algorithm.doit.examples.chap05;

import java.util.Scanner;

public class EuclidGCD {
    static int gcd(int x, int y){
        if(y==0)
            return x;
        else {
            System.out.println(x+" "+y);
            return gcd(y, x % y);
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("두 정수의 최대공약수 구하기 : "+gcd(20,24));

    }
}
