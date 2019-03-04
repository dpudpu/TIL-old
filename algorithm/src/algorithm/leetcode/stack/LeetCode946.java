package algorithm.leetcode.stack;

import java.util.Stack;

public class LeetCode946 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int point = 0;

        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[point]) {
                stack.pop();
                point++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5}, popped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
