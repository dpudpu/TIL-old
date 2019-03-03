package algorithm.leetcode.stack;

import java.util.Stack;

public class LeetCode739 {
    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < T.length; i++) {
            int p = i - 1;
            while (!stack.isEmpty() && stack.peek() < T[i]) {
                if (res[p] == 0) {
                    res[p] = i - p;
                    stack.pop();
                }
                p--;
            }
            stack.push(T[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        for (int t : dailyTemperatures(T)) {
            System.out.print(t + ", ");
        }
    }
}
