package algorithm.backjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Z {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size;
        int r;
        int c;
//        while (true) {
            String[] input = br.readLine().split(" ");

            size = (int) Math.pow(2, Integer.parseInt(input[0]));
            r = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);
//            if (size > 0 && size <= 15 && r > 0 && r <= size / 2 && c > 0 && c <= size / 2)
//                break;
//        }

        int[][] arr = new int[size][size];
        arr = solution(arr,0,0,0 );


        for(int i=0; i<size; i++){
            for(int j=0;j<size;j++)
                System.out.print(arr[i][j]+"  ");
            System.out.println();
        }


    }

    public static int[][] solution(int[][] arr, int row, int col, int cnt) {

        for (int i = row; i < row + 2; i++) {
            for (int j = col; j < col + 2; j++) {
                System.out.println(j + " " + i);
                arr[i][j] = cnt++;
            }
        }
        System.out.println();

        if (arr.length == row+2)
            return arr;
        else if (row < col)
            solution(arr, row + 2, col-2, cnt);
        else {
            solution(arr, row, col + 2, cnt);
        }
        return arr;
    }

}
