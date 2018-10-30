package algorithm.backjoon.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

/*
https://www.acmicpc.net/problem/1406
에디터
 */
public class Quiz1406 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> iterator = list.listIterator(list.size());
        for (int i=0;i<str.length();i++)
            iterator.add(str.charAt(i));
        int N = Integer.parseInt(br.readLine()); // 명령어 횟수

        while(N-->0){
            String command = br.readLine();
            try {
                switch (command) {
                    case "L":
                        iterator.previous();
                        continue;
                    case "D":
                        iterator.next();
                        continue;
                    case "B":
                        iterator.previous();
                        iterator.remove();
                        continue;
                    default:
                        iterator.add(command.charAt(2));
                }
            }catch(Exception e){}
        }
        StringBuffer sb = new StringBuffer(600000);
        for (char l : list)
            sb.append(l);
        System.out.println(sb);
    }
}

/*
https://www.acmicpc.net/problem/1406
에디터
insert(int index, char[] str, int offset, int len)
sb의 index 위치에 ch[offset]부터 len 까지 입력
 */

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        // 문자열을 배열에 입력 받은 뒤 리스트에 담아주기.
//
//        sb.append(br.readLine());
//        int N = Integer.parseInt(br.readLine()); // 명령어 횟수
//        int ptr = sb.length(); // 커서
//
//        for (int i = 0; i < N; i++) {
//            String command = br.readLine();
//            switch (command) {
//                case "L":
//                    if (ptr > 0)
//                        ptr--;
//                    continue;
//                case "D":
//                    if (ptr < N)
//                        ptr++;
//                    continue;
//                case "B":
//                    if (ptr > 0)
//                        sb.deleteCharAt(--ptr);
//                    continue;
//                default:
//                    command.charAt(2);
////                    char[] ch = command.toCharArray();
//                    sb.insert(ptr++,command.charAt(2));
//            }
//        }
//        System.out.print(sb);
//    }

