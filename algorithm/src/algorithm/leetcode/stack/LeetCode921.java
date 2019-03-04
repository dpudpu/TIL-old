package algorithm.leetcode.stack;

import java.util.Stack;

public class LeetCode921 {
    public static int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack();
        int cnt = 0;

        for (char c : S.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else if (!stack.isEmpty() && c == ')')
                stack.pop();
            else
                cnt++;
        }
        while (!stack.isEmpty()) {
            stack.pop();
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("()))("));
    }
}
