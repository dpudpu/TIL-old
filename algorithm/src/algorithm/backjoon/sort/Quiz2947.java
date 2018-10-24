package algorithm.backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//버블정렬
public class Quiz2947 {
    public static void main(String args[]) throws IOException {
        int[] piece = new int[5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums;

        nums = br.readLine().split(" ");
        for (int i = 0; i < piece.length; i++)
            piece[i] = Integer.parseInt(nums[i]);

        int tmp=0;
        for(int i=0; i<piece.length-1;i++){
            for (int j=0; j<piece.length-1; j++){
                if(piece[j]>piece[j+1]){
                    tmp=piece[j];
                    piece[j]=piece[j+1];
                    piece[j+1]=tmp;
                    for(int p :piece)
                        System.out.print(p+" ");
                    System.out.println();
                }
            } // for
        } // for
    } // main
}
