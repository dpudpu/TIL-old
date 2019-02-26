package algorithm.leetcode.dinamic;


public class LeetCode873 {
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int max = 0;
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                int sum = A[l]+A[r];
                if(sum > A[i])
                    r--;
                else if(sum<A[i])
                    l++;
                else{
                    dp[r][i] = dp[l][r]+1;
                    max= Math.max(max, dp[r][i]);
                    r--;
                    l++;
                }
            }
        }
        return max == 0 ? 0 : max + 2;


//        1. solution N^2logN
//        int max = 0;
//        for (int i = 0; i < A.length - 2; i++) {
//            for (int j = i + 1; j < A.length - 1; j++) {
//                int cnt = 0;
//                int first = i;
//                int second = j;
//                for (int k = j + 1; k < A.length; k++) {
//                    if (A[first] + A[second] == A[k]) {
//                        cnt ++;
//                        first = second;
//                        second = k;
//                    }else if(A[first] + A[second] < A[k])
//                        break;
//                }
//                max = max < cnt ? cnt : max;
//            }
//            if(A.length-i < max+2)
//                break;
//        }
//
//        return max = max == 0 ? 0 : max + 2;

    }


    public static void main(String[] args) {
        int A[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(new LeetCode873().lenLongestFibSubseq(A));
    }
}
