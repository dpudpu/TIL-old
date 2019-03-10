package algorithm.programmers.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MoreSpicy {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> foods = new PriorityQueue<Integer>();

        for (int food : scoville) {
            foods.add(food);
        }

        while (foods.peek() < K) {
            int temp1 = foods.poll();
            if (foods.peek() == null)   return -1;
            int temp2 = foods.poll();

            int newScoville = temp1 + temp2 * 2;
            foods.add(newScoville);
            answer++;
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution(scoville, k));
    }
}
