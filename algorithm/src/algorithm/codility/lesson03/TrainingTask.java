package algorithm.codility.lesson03;

import java.util.Arrays;

public class TrainingTask {
    public static int solution(int[] A) {
        int res=1;

        Arrays.sort(A);

        for(int num : A){
            if(num!=res)
                return res;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {2,3,1,5};
        System.out.println(solution(A));
    }
}
