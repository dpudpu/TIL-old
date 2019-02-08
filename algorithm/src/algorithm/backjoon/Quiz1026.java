package algorithm.backjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Quiz1026 {
    public static int solution(int[] a, int[] b) {
        int length = b.length;
        boolean[] flags = new boolean[length];
        int sum = 0;
        Arrays.sort(a);


        for (int i = 0; i < length; i++) {
            int max = 0;
            for (int j = 0; j < length; j++) {
                if (!flags[j]) {
                    if (b[j] > max)
                        max = b[j];
                }
            } // for
            for (int j = 0; j < length; j++) {
                if (!flags[j]) {
                    if (b[j] == max) {
                        flags[j] = true;
                        sum += a[i] * max;
                        break;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int a[] = new int[N];
        int b[] = new int[N];

        for (int i = 0; i < N; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < N; i++)
            b[i] = sc.nextInt();
        System.out.println(solution(a, b));
    }

}