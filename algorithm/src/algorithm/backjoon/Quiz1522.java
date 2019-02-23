package algorithm.backjoon;


import java.util.LinkedList;
import java.util.Scanner;

public class Quiz1522 {
    public static int solution(String str) {
        int cnt = 0;
        char first = str.charAt(0);
        char second = str.charAt(0) == 'a' ? 'b' : 'a';

        LinkedList<Character> list = new LinkedList();

        for (char ch : str.toCharArray())
            list.addLast(ch);


        while (first == list.getLast())
            list.removeLast();

        while (list.lastIndexOf(first) != list.indexOf(second) - 1) {
            int si = list.indexOf(second);
            list.remove(si);
            int fi = list.lastIndexOf(first);
            list.remove(fi);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
