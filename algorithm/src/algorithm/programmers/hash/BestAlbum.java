package algorithm.programmers.hash;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
베스트앨범
 */
public class BestAlbum {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new TreeMap<>();
        Map<Integer, String> map = new TreeMap<>();

        for (int i = 0; i < genres.length; i++) {
            total.put(genres[i], total.get(genres[i]) == null ? plays[i] : total.get(genres[i]) + plays[i]);
            map.put(plays[i], genres[i]);
        }

//        Iterator<String> iterator = ((TreeMap<String, Integer>) total).descendingKeySet().iterator();
        Iterator<String> iterator = total.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(solution(genres, plays));
    }
}
