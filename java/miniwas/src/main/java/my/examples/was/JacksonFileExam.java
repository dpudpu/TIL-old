package my.examples.was;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JacksonFileExam {
    public static void main(String[] args) throws Exception{
        MiniWasConfiguration miniWasConfiguration =
                new MiniWasConfiguration();
        miniWasConfiguration.setStaticDir("/tmp/www");
        miniWasConfiguration.setClassPath(".");

        // 객체를 json메시지 메시지로 변환한다. (직렬화한다.)
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("/tmp/was.json"), miniWasConfiguration);

        // 역직렬화
        MiniWasConfiguration readObj =
                objectMapper.readValue(new File("/tmp/was.json"), MiniWasConfiguration.class);
        System.out.println(readObj.getClassPath());
        System.out.println(readObj.getStaticDir());
    }
}
