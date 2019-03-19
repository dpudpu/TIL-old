package algorithm.codility.lesson02;

public class CyclicRotation {
    public static int[] solution(int[] A, int K) {
        int n = A.length;
        int res[] = new int[n];

        for(int i=0; i<n; i++){
            int shift = (i+K)%n;
            res[shift] = A[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {4,5,6,71,1}; // 0-3 1-4 2-1(5) 3-2(6) 4-3(7(
        int K = 3;
        for(int a : solution(A,K))
            System.out.print(a+" ");
    }
}
