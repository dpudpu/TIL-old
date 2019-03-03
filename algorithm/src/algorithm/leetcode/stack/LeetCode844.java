package algorithm.leetcode.stack;

import java.util.Stack;

public class LeetCode844 {
    public static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public static String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c : S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        String S = "y#fo##f", T = "y#f#o##f";
        System.out.println(backspaceCompare(S, T));
    }
}
