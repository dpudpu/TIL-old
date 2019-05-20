package algorithm.leetcode.stack;

import java.util.Stack;

public class LC1047 {
    public static String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int size = -1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(sb.length() ==0) {
                sb.append(c);
                size++;
            }else if(sb.charAt(size)==c){
                sb.deleteCharAt(size--);
            }else{
                sb.append(c);
                size++;
            }

        }

        return sb.toString();
    }

//    public static String removeDuplicates(String S) {
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < S.length(); i++) {
//            char c = S.charAt(i);
//            if (stack.empty()) {
//                stack.push(c);
//            } else if (stack.peek() == c) {
//                stack.pop();
//            } else {
//                stack.push(c);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (final Character character : stack) {
//            sb.append(character);
//        }
//        return sb.toString();
//    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
