package algorithm.codility.lesson04;


public class MaxCounters {
    public static int[] solution(int N, int[] A) {
        int res[] = new int[N];
        int maxCounter = 0;
        int checkMax = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > N) {
                checkMax = maxCounter;
            } else {
                int index = A[i]-1;
                if (checkMax != 0 && res[index] < checkMax)
                    res[index] = checkMax;
                res[index] += 1;
                maxCounter = Math.max(res[A[i] - 1], maxCounter);
            }
        }

        for (int i = 0; i < N; i++) {
            if (res[i] < checkMax)
                res[i] = checkMax;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {2,2,2,3,4,5,7,6,4,2,3,7,6,4,3,5,6};
        int N = 6;
        for (int n : solution(N, A))
            System.out.println(n);
    }
}
