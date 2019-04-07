package algorithm.leetcode.etc;


public class LeetCode1021 {

    public static String removeOuterParentheses(String S) {
        int leftCnt = 0;
        int rightCnt = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ')')
                rightCnt++;
            else
                leftCnt++;

            if (rightCnt == leftCnt) {
                sb.append(S.substring(i - rightCnt - leftCnt + 2, i));
                leftCnt = 0;
                rightCnt = 0;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
