package algorithm.kakao.y2019;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 오픈채팅방
public class Quiz01 {

    public static void main(String args[]) throws IOException {
        String br = "\"Enter uid1234 Muzi\",\"Enter uid4567 Prodo\",\"Leave uid1234\"" +
                ",\"Enter uid1234 Prodo\",\"Change uid4567 Ryan\"";

        StringTokenizer st = new StringTokenizer(br, ",,\"");
        System.out.println(st.countTokens());
        String[] record = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            record[i++] = st.nextToken().trim();
        }

        solution(record);

    }

    public static void solution(String[] record) {
        Map<String, String> user = new HashMap<String, String>();
        String[] command = new String[record.length];
        String[] uid = new String[record.length];
        String[] name = new String[record.length];

        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            command[i] = str[0];
            uid[i] = str[1];
            if (str.length == 3)
                name[i] = str[2];
        }

        for (int i = 0; i < record.length; i++) {

            switch (command[i]) {
                case "Enter":
                    user.put(uid[i], name[i]);
                    break;
                case "Change":
                    user.put(uid[i], name[i]);
                    break;
            }
        }
        for (int i = 0; i < record.length; i++) {
            switch (command[i]) {
                case "Enter":
                    System.out.println(user.get(uid[i]) + "님이 들어왔습니다");
                    break;
                case "Leave":
                    System.out.println(user.get(uid[i]) + "님이 나갔습니다");
                    break;
            }
        }
    }
}
