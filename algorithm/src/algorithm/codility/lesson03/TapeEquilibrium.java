package algorithm.codility.lesson03;

public class TapeEquilibrium {
    public static int solution(int A[]) {
        int minGap = Integer.MAX_VALUE;
        int backSum = 0;
        int frontSum = 0;

        for (int a : A)
            backSum += a;

        for (int i = 0; i<A.length-1;i++) {
            frontSum += A[i];
            backSum -= A[i];
            int gap = Math.abs(backSum - frontSum);
            minGap = Math.min(minGap, gap);
        }

        return minGap;
    }

    public static void main(String[] args) {
        int A[] = {3, 2};
        System.out.println(solution(A));
    }
}
