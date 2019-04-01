package algorithm.leetcode.etc;

public class LC028 {
    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle) || needle.equals(""))
            return 0;

        for(int i=0; i<haystack.length()-needle.length()+1; i++){
            for(int j=0; j<needle.length(); j++){
                if(needle.charAt(j) != haystack.charAt(i+j))
                    break;
                if(needle.length()-1 == j)
                    return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "a", needle = "";
        System.out.println(strStr(haystack, needle));
    }
}
