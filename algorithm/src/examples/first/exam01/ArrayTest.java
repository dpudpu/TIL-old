package examples.first.exam01;

import java.sql.SQLOutput;

public class ArrayTest {
    public static void main(String[] args){
        int[] odd = new int[2];
        odd[0] = 1;
        odd[1] = 2;

        int[] odd1 = {1,3,5,6};

        for(int i : odd){
            System.out.println(i);
        }
        for(int i:odd1){
            System.out.println(i);
        }


        ////////////////////////////

        char[] alpha = new char[26];
        for(int i=alpha.length-1; i>=0;i--){
            alpha[i] = (char)(i+65);
            System.out.print(alpha[i]+" ");
        }
        System.out.println();
        for(char i=0, cnt='z'; cnt>='a'; cnt--, i++){
            alpha[i] = cnt;
            System.out.print(alpha[i]+" ");
        }

        System.out.println();

        int[][] arr = new int[7][4];

        for(int i=0, cnt=1; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++, cnt++){
                arr[i][j]= cnt;
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        char[][] arr1 = new char[5][5];

        for(int i=0, cnt=65; i<arr1.length; i++){
            for(int j=0; j<arr1[i].length; j++, cnt++){
                arr1[i][j]= (char)cnt;
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }

    }
}
