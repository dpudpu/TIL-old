package algorithm.leetcode;

public class LeetCode014 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";

        int minLength = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.length; i++)
            minLength = Math.min(minLength, strs[i].length());

        for(int i=0; i<minLength; i++){
            char ch = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                if(ch != strs[j].charAt(i)) return sb.toString();
            }
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {};
        System.out.println(longestCommonPrefix(strs));
    }
}
