package algorithm.programmers.hash;


import java.util.HashMap;
import java.util.Map;

/*
https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
완주하지 못한 선수
 */
public class Marathon {

//    public static String solution(String[] participant, String[] completion) {
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        int i;
//        for(i=0; i<participant.length; i++){
//            if(!participant[i].equals(completion[i]))
//                return participant[i];
//        }
//        return participant[i];
//    }

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String answer ="";
        for (String p : participant)
            map.put(p, map.get(p) == null ? 1 : map.get(p) + 1);
        for (String p : completion)
            map.put(p, map.get(p)-1);

        for(String p : map.keySet()){
            if(map.get(p)==1) answer=p;
        }
        return answer;
    }


    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden", "kiki"};
        String[] completion = {"eden", "kiki", "leo"};
        System.out.println(solution(participant, completion));
    }
}
