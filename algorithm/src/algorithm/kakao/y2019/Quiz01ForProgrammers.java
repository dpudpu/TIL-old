package algorithm.kakao.y2019;

        import java.util.HashMap;
        import java.util.Map;

// 오픈채팅방
public class Quiz01ForProgrammers {

    public static void main(String args[]){
        String[] record = {	"Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan",
                "Leave uid4567"};

        String[] re = solution(record);

        for(String r : re){
            System.out.println(r);
        }

    }

    public static String[] solution(String[] record) {
        Map<String, String> user = new HashMap<String, String>();
        String[] command = new String[record.length];
        String[] uid = new String[record.length];
        String[] name = new String[record.length];
        int cnt=0;

        for(int i=0;i<record.length;i++) {
            String[] str = record[i].split(" ");
            command[i] = str[0];
            uid[i]=str[1];
            if(str.length==3)
                name[i]=str[2];
        }

        for(int i=0;i<record.length;i++) {
            switch (command[i]){
                case "Enter":
                    user.put(uid[i],name[i]);
                    break;
                case "Change":
                    user.put(uid[i],name[i]);
                    cnt--;
                    break;
            }
        }

        String[] answer = new String[record.length+cnt];

        int j=0;
        for(int i=0;i<record.length;i++){
            switch (command[i]) {
                case "Enter":
                    answer[j] = user.get(uid[i]) + "님이 들어왔습니다.";
                    j++;
                    break;
                case "Leave":
                    answer[j] = user.get(uid[i]) + "님이 나갔습니다.";
                    j++;
                    break;
                case "Change":
                    break;
            }
        }
        return answer;
    }
}

