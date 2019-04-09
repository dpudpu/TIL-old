package algorithm.leetcode;

public class LeetCode007 {
    public static int reverse(int x) {
        if(x==Integer.MIN_VALUE) return 0;

        int reverseNum = 0;
        boolean isMinus = x < 0 ? true : false;
        x = Math.abs(x);

        while (x != 0) {
            if((long)reverseNum*10 + x%10 > Integer.MAX_VALUE)
                return 0;

            reverseNum = reverseNum*10 + x%10;
            x/=10;

        }

        return isMinus ? -reverseNum: reverseNum;
    }

    public static void main(String[] args) {

        System.out.println(reverse(-2147483641));
        System.out.println(reverse(1534236463));
        System.out.println(reverse(123));
        System.out.println(reverse(120));

    }
}
