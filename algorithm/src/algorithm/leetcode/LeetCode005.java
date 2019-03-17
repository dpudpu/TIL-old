package algorithm.leetcode;

public class LeetCode005 {
    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;

        String res = "";
        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = s.length() - 1; j >= 0; j--) {
                int l = i;
                int r = j;
                boolean check = true;
                while (l <= r) {
                    if (arr[l] != arr[r]) {
                        check = false;
                        break;
                    }
                    l++;
                    r--;
                }
                if (check) {
                    res = res.length() > j - i ? res : s.substring(i, j + 1);
                }
            }
            if (res.length() > s.length() - i)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("saas"));
    }
}
