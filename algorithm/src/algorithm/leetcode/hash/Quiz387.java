package algorithm.leetcode.hash;

/*
https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class Quiz387 {
    public static int firstUniqChar(String s) {
        if (s.length() == 1)
            return 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] == chars[j] && i != j) {
                    break;
                } else if (j == chars.length - 1)
                    return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("z"));
    }
}
