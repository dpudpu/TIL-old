package algorithm.backjoon.linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

//조세퍼스 문제
public class Quiz1158 {
    public static void solution(int N, int M) { // N - 인원수, M - M번째 제거
        int cnt = 1;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int i = 0;
        System.out.print("<");
        while (!list.isEmpty()) {
            if ((cnt %= M) == 0) {
                if(list.size()!=1) {
                    System.out.print(list.get(i) + ", ");
                }
                else
                    System.out.println(list.get(i)+">");
                list.remove(i);
                i--;
            }
            cnt++;
            i++;

            if (i == list.size()) // taile.next = head 개념
                i = 0;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        solution(N,M);
    }
}
