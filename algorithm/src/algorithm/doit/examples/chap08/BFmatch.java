package algorithm.doit.examples.chap08;

import java.util.Scanner;

public class BFmatch {
    static int bfMatch(String txt, String pat) {
        int pt = 0;//txt커서
        int pp = 0; //pat커서

        while(pt!=txt.length()&&pp!=pat.length()){
            if(txt.charAt(pt)==pat.charAt(pp)){
                pt++;
                pp++;
            }else{
                pt=pt-pp+1;
                pp=0;
            }
        }
        if(pp==pat.length())    //검색 성공
            return pt -pp;
        return -1;              //검색실패
    }

    static int bfMatchLast(String txt, String pat) {
        int pt = 0;//txt커서
        int pp = 0; //pat커서

        while(pt!=txt.length()&&pp!=pat.length()){
            if(txt.charAt(pt)==pat.charAt(pp)){
                pt++;
                pp++;
            }else{
                pt=pt-pp+1;
                pp=0;
            }
        }
        if(pp==pat.length())    //검색 성공
            return (pt -pp)+pat.length()-1;
        return -1;              //검색실패
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = sc.next();
        System.out.print("패턴 : ");
        String s2 = sc.next();

        int idx = bfMatchLast(s1,s2);

        if(idx==-1)
            System.out.println("패턴 일치 x");
        else{
            // 일치하는 문자 바로 앞까지의 길이를 구합니다.
//            int len=0;
//            for(int i=0; i<idx; i++)
//                len += s1.substring(i,i+1).getBytes().length;
//            len+=s2.length();
            System.out.println((idx+1)+"번째 문자부터 일치");
        }

    }
}
