package algorithm.codility.lesson04;

import java.util.HashSet;
import java.util.Set;

public class TrainingTask {
    public static int solution(int[] A) {
        Set<Integer> set = new HashSet<>(A.length);

        int cnt = 0;
        for (int a : A)
            set.add(a);
        while(true){
            cnt++;
            if(!set.contains(cnt))
                return cnt;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(A));
    }
}
