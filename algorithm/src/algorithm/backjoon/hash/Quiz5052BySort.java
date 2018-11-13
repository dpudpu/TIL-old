package algorithm.backjoon.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Quiz5052BySort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n= Integer.parseInt(br.readLine());
            String[] numbers = new String[n];
            for (int i = 0; i < n; i++)
                numbers[i] =br.readLine();

            Arrays.sort(numbers);
            boolean check = true;
            for (int i = 1; i < n && check; i++)
                check = !numbers[i].startsWith(numbers[i - 1]);
            System.out.println(check?"YES":"NO");
        }
    }
}
