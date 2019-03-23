package algorithm.leetcode;

public class LeetCode771 {
    public static int numJewelsInStones(String J, String S) {
        int cnt=0;
        for(char c : S.toCharArray()){
            if(J.indexOf(c) != -1){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA","aAAbbbb"));
    }
}
