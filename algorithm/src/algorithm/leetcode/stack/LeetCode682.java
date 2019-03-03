package algorithm.leetcode.stack;

import java.util.Stack;

public class LeetCode682 {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "+":
                    int top = stack.pop();
                    int newtop = stack.peek() + top;
                    stack.push(top);
                    stack.push(newtop);
                    continue;
                case "D":
                    stack.push(stack.peek() * 2);
                    continue;
                case "C":
                    stack.pop();
                    continue;
                default:
                    stack.push(Integer.parseInt(ops[i]));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(ops));
    }
}
