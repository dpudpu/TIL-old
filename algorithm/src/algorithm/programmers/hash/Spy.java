package algorithm.programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Spy {
    public static int solution(String[][] clothes) {

        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            System.out.println(clothes[i][1]);
            if (map.get(clothes[i][1]) == null)
                map.put(clothes[i][1], 1);
            else
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        }

        for(String key : map.keySet())
            answer*=map.get(key)+1;

        return answer-1;
    }

    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"},
                {"11", "!11"}};
        System.out.println(solution(clothes));
    }
}
