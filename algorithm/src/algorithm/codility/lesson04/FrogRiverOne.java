package algorithm.codility.lesson04;


import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    public static int solution(int X, int[] A) {
        Set<Integer> set = new HashSet(X);

        int i=0;
        for(int a : A){
            set.add(a);
            if(set.size()==X)
                return i;
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int A[] = {1, 3, 1, 3, 2, 1, 3};
        int X = 3;
        System.out.println(solution(X,A));
    }
}
