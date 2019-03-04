package algorithm.leetcode.stack;

import java.util.Stack;

public class LeetCode856 {
    public static int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0);

        for (char c : S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int top = stack.pop();
                int newtop = stack.pop();
                stack.push(newtop + Math.max(top * 2, 1));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String S = "(()(()))";
        System.out.println(scoreOfParentheses(S));
    }
}
