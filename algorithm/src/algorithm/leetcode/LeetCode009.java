package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode009 {
    public static boolean isPalindrome(int x) {
            if (x<0 || (x!=0 && x%10==0)) return false;
            int rev = 0;
            while (x>rev){
                rev = rev*10 + x%10;
                x = x/10;
            }
            return (x==rev || x==rev/10);
//
//        if (x < 0)
//            return false;
//        else if (x < 10)
//            return true;
//        List list = new ArrayList();
//        int size = -1;
//        while (x > 0) {
//            size++;
//            list.add(x % 10);
//            x /= 10;
//        }
//
//        for (int i = 0; i < size / 2+1; i++) {
//            if (list.get(i) != list.get(size - i))
//                return false;
//        }
//
//        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(22322));
    }
}
