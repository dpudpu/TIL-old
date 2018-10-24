package algorithm.kakao.y2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KakaoQuiz02 {
    public static void main(String args[]){
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//////        while(true) {
//////            System.out.print("입력 : ");
//////            String str = null;
//////            try {
//////                str = br.readLine();
//////            } catch (IOException e) {
//////                e.printStackTrace();
//////            }
            String[] socres = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
            for(String str : socres)
                solution(str.toUpperCase());
        }

    public static void solution(String str){
        int score=0; // 점수
        int cntNum=0; // 숫자 배열 인덱스값
        int[] nums = new int[3]; // 숫자를 담을 배열

        StringTokenizer st  = new StringTokenizer(str,"*,#,S,D,T");
        while (st.hasMoreTokens()){
            nums[cntNum++]=Integer.parseInt(st.nextToken());
        }

        cntNum=0;
        for(int cnt=0; cnt<str.length();cnt++){
            if (str.charAt(cnt) == 'S')
                cntNum++; // 1의 제곱이라서 값 변경x
            else if (str.charAt(cnt) == 'D') // 2의 제곱
                nums[cntNum] *= nums[cntNum++];
            else if (str.charAt(cnt) == 'T') // 3의 제곱
                nums[cntNum] *= nums[cntNum] * nums[cntNum++];
            else if (str.charAt(cnt) == '*') {
                for(int i = (cntNum-2<0 ? 0:cntNum-2); i<cntNum; i++)
                    nums[i] *= 2;
            }
            else if (str.charAt(cnt) == '#')
                            nums[cntNum-1] *= -1;
        }
        for(int i=0; i<nums.length;i++){
            score+=nums[i];
        }
        System.out.println("점수 : "+score);
    }
}