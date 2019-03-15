package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode003 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();

        int answer = 1;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length - 1; i++) {
            Set<Character> set = new HashSet<>();
            set.add(arr[i]);
            int cnt = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (set.contains(arr[j]))
                    break;
                set.add(arr[j]);
                cnt++;
            }
            answer = Math.max(cnt, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
