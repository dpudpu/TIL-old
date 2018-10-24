package algorithm.backjoon.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Quiz6603 {
    public static void recursion(int j, int[] lotto, int[] printLotto, int cnt) {
        if (cnt == 6) { //  선택된 번호가 6개가 되면 출력
            for (int l : printLotto)
                System.out.print(l + " ");
            System.out.println();
        } else {
            for (int i = j; i < lotto.length; i++) {
                printLotto[cnt] = lotto[i];
                recursion(i + 1, lotto, printLotto, cnt + 1);
            }
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<int[]> lottoList = new ArrayList<>(); // 예제를 저장해줄 리스트

        int length;
        while ((length = sc.nextInt()) != 0) {
            int[] lotto = new int[length];

            for (int i = 0; i < length; i++)
                lotto[i] = sc.nextInt();

            lottoList.add(lotto); // 로또 배열을 리스트에 추가해준다.
        }

        for (int[] lotto : lottoList) {
            int[] printLotto = new int[6]; // 출력용 로또배열
            recursion(0, lotto, printLotto, 0);
            System.out.println();
        }
    }
}
