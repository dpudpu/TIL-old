package algorithm.doit.examples.chap03;

import java.util.Arrays;
import java.util.Scanner;

//Arrays.binarySearch로 이진 검색
public class BinarySearchTester {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num=sc.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력");
        System.out.print("x[0] : ");
        x[0] = sc.nextInt();

        for(int i=1;i<num;i++){
            do{
                System.out.print("x["+i+"] :");
                x[i] =sc.nextInt();
            }while(x[i]<x[i-1]);
        }

        System.out.print("검색할 값 : ");
        int ky = sc.nextInt();

        int idx= Arrays.binarySearch(x,ky);

        if(idx==-1)
            System.out.println("그 값의 요소 x");
        else
            System.out.println(ky+"는 x["+idx+"]에 있습니다.");

    }
}
