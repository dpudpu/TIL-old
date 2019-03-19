package algorithm.codility.lesson06;

import java.util.Arrays;

// https://app.codility.com/programmers/lessons/6-sorting/triangle/
// sum의 결과가 int의 max를 초과하면 오버플로우가 발생해서 -Integer.MAX_VALE가 된다.
public class Triangle {
    public static int solution(int[] A) {
        Arrays.sort(A);
        int n = A.length - 1;
        for (int i = n; i >= 2; i--) {
            long sum = (long)A[i - 1] + A[i - 2];
            if (A[i] < sum)
                return 1;
        }
        return 0;
    }
//    public static int solution(int[] A) {
//        Arrays.sort(A);
//        int n = A.length - 1;
//        for (int i = n; i >= 2; i--) {
//            if (A[i] - A[i - 1] < A[i - 2])
//                return 1;
//        }
//        return 0;
//    }

    public static void main(String[] args) {
        int A[] = {10, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        System.out.println(solution(A));
    }
}
