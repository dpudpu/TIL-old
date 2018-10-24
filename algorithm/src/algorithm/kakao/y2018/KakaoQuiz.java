package algorithm.kakao.y2018;

import java.util.Scanner;

public class KakaoQuiz {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("n 입력 :");
        n=sc.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        System.out.print("arr1 : ");
        for(int i=0; i<arr1.length; i++)
            arr1[i] = sc.nextInt();

        System.out.print("arr2 : ");
        for(int i=0; i<arr1.length; i++)
            arr2[i] = sc.nextInt();


        for(int i=0; i<n; i++){
            String fm = "%0"+n+"d";
            String binary1= String.format(fm,Integer.parseInt(Integer.toBinaryString(arr1[i])));
            String binary2= String.format(fm,Integer.parseInt(Integer.toBinaryString(arr2[i])));

            for(int j=0; j<n; j++){  /////// 1번
                if(binary1.charAt(j)=='1')
                    System.out.print("#");
                else
                    System.out.print(" ");
            }
            System.out.print("   ");

            for(int j=0; j<n; j++){ //////////2번
                if(binary2.charAt(j)=='1')
                    System.out.print("#");
                else
                    System.out.print(" ");
            }
            System.out.print("   ");

            for(int j=0; j<n; j++){ //////// 합친거
                if(binary2.charAt(j)=='1'||binary1.charAt(j)=='1')
                    System.out.print("#");
                else
                    System.out.print(" ");
            }


            System.out.println();

        }

    }
}
