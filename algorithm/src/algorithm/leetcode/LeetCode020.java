package algorithm.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class LeetCode020 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> pairBrackets = new HashMap<>();
        pairBrackets.put('(', ')');
        pairBrackets.put('[', ']');
        pairBrackets.put('{', '}');

        char[] brackets = s.toCharArray();

        if (s.length() == 0)
            return true;
        else if (s.length() % 2 == 1 || !pairBrackets.containsKey(brackets[0]))
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (pairBrackets.containsKey(brackets[i]))
                stack.push(brackets[i]);
            else if (pairBrackets.get(stack.pop()) != brackets[i])
                return false;
        }

        if(!stack.empty())
            return false;

        return true;
    }

    public static void main(String[] args) {
        String s = "((";
        System.out.println(isValid(s));
    }
}
