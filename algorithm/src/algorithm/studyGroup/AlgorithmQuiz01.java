package algorithm.studyGroup;

import java.util.Scanner;

// 두 문자열을 사전 순으로 비교
// str1이 앞서면 -1 출력
// str2가 앞서면 1 출력
// 같은 문자열이면 0 출력
public class AlgorithmQuiz01 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str1;
        String str2;

        while(true) {
            System.out.print("첫번쨰 문자열 입력 : ");
            str1 = sc.nextLine();
            System.out.print("두번쨰 문자열 입력 : ");
            str2 = sc.nextLine();
            System.out.println(solution(str1.toLowerCase(), str2.toLowerCase()));
            // 대소문자 구별을 없애기 위하여 소문자로 변환.
        }
    }
    public static int solution(String str1, String str2){
        int result=0;
        if(!str1.equals(str2)){ // 같은 문자열이면 for문 실행하지 않고 0값 반환.
            for(int j=0;j<str1.length() && j<str2.length();j++) {
                if (str1.charAt(j) < str2.charAt(j)) { // str1이 앞서는 순서일 때
                    result=-1;
                    break;
                }
                else if (str1.charAt(j) > str2.charAt(j)) { // str2이 앞서는 순서일 때
                    result=1;
                    break;
                }
                if(j+1==str1.length() || j+1==str2.length()) // 자릿수가 다른데 앞자리들이 똑같을 경우.
                    result = (str1.length()>str2.length()) ? 1 : -1;

            } // for
         } // if(!str1.equals(str2))
        return result;
    }
}
