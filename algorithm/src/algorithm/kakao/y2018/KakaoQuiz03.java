package algorithm.kakao.y2018;

import java.util.ArrayList;
import java.util.List;

public class KakaoQuiz03 {
    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork"
                , "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); // 50
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju"
                , "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"})); // 21
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork"
                , "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); // 60
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork"
                , "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); // 52
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"})); // 16
        System.out.println(solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); // 25
    }


    public static int solution(int cacheSize, String[] cities) {
        int time = 0;
        List<String> cache = new ArrayList<String>();

        if (cacheSize == 0) // cacheSize 0일때
            return cities.length * 5;

        for (String city : cities) {
            city = city.toUpperCase(); // 대소문자 구분을 하지 않는다
            if (cache.contains(city)) {
                time += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                time += 5;
                if (cache.size() >= cacheSize)
                    cache.remove(0);
                cache.add(city);
            }
        }


        return time;
    }
}

