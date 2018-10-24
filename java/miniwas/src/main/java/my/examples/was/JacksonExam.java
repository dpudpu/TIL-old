package my.examples.was;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExam {
    public static void main(String[] args) throws Exception{
        MiniWasConfiguration miniWasConfiguration =
                new MiniWasConfiguration();
        miniWasConfiguration.setStaticDir("/tmp/www");
        miniWasConfiguration.setClassPath(".");

        // 객체를 json메시지 메시지로 변환한다. (직렬화한다.)
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonConfiguration =
                objectMapper.writeValueAsString(miniWasConfiguration);

        System.out.println(jsonConfiguration);

        // 역직렬화
        String jsonData = "{\"staticDir\":\"/tmp/www\",\"classPath\":\".\"}";
        MiniWasConfiguration readObj =
                objectMapper.readValue(jsonData, MiniWasConfiguration.class);
        System.out.println(readObj.getClassPath());
        System.out.println(readObj.getStaticDir());
    }
}
