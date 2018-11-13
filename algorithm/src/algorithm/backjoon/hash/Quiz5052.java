package algorithm.backjoon.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz5052 {
    

    public static void check(String str[], int n){
        boolean check = false;
        for (int str1 = 0; str1 < n; str1++) {
            for (int str2 = str1+1; str2 < n; str2++) {
                if ((str[str1].matches(".*^" + str[str2] + ".*"))
                        || (str[str2].matches(".*^" + str[str1] + ".*"))) {
                    check=true;
                }
            }
        }
        if (check==true)
            System.out.println("NO");
        else
            System.out.println("YES");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트 케이스
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            // 숫자 개수
            int n = Integer.parseInt(br.readLine());
            String str[] = new String[n];
            for (int k = 0; k < n; k++) {
                str[k] = br.readLine();
            }
            check(str, n);
        }
    }
}
