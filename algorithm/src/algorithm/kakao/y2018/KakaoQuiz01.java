package algorithm.kakao.y2018;


import java.util.Scanner;

public class KakaoQuiz01 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("n 입력 : ");
//        int n = sc.nextInt();

        int arr1[] = new int[]{9,20,28,18,11};
        int arr2[] = new int[]{30,1,21,17,28};

        solution(5, arr1, arr2);
    }
    public static void solution(int num, int[] arr1, int[] arr2){
        int orResult=0;
        String binary;
        String out;
        for(int i=0; i<num; i++){
            out="";
            orResult = arr1[i]|arr2[i];
            binary = Integer.toBinaryString(orResult);

            for(int j=0; j<binary.length(); j++){
                if(binary.charAt(j)=='0')
                    out+=" ";
                else
                    out+="#";
            }
            System.out.println(out+"  "+binary);
        }
    }
}
