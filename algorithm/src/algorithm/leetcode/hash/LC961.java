package algorithm.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class LC961 {
    public static int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : A){
            if(map.get(num)!=null)
                return num;
            map.put(num,0);
        }

        return -1;
    }

    public static void main(String[] args) {
        int A[] = {5,1,5,2,5,3,5,4};
        System.out.println(repeatedNTimes(A));
    }
}
