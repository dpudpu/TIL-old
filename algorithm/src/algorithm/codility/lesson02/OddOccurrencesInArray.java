package algorithm.codility.lesson02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class OddOccurrencesInArray {
    public static int solution(int[] A) {
        Set<Integer> set = new HashSet();

        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i]))
                set.remove(A[i]);
            else
                set.add(A[i]);

        }
        Iterator<Integer> iter = set.iterator();

        return iter.next();
    }

    public static void main(String[] args) {
        int A[] = {9,3,9,3,9,7,9};
        System.out.println(solution(A));
    }
}
