package algorithm.leetcode;

public class LeetCode007 {
    public static int reverse(int x) {
        if (Integer.MAX_VALUE-1 < x || -Integer.MAX_VALUE > x)
            return 0;

        int answer = 0;
        int num=x;
        int cnt = 1;
        while(num!=0) {
            cnt*=10;
            num /= 10;
        }
        cnt/=10;
        int c=1;
        while(cnt>0){
            int n = x/cnt;
            answer+=n*c;
            c*=10;
            x%=cnt;
            cnt/=10;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
