package practice;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonFileExam {
    public static void main(String args[]){
        ObjectMapper objectMapper = new ObjectMapper();
        MiniWasConfiguration miniWasConfiguration = new MiniWasConfiguration();
        miniWasConfiguration.setClassPath("/");
        miniWasConfiguration.setStaticDir("/tmp");

        try {
            objectMapper.writeValue(new File("/tmp/j.json"),miniWasConfiguration);

            MiniWasConfiguration m = objectMapper.readValue(new File("/tmp/j.json"), MiniWasConfiguration.class);
            System.out.println(m.getClassPath()+"  "+m.getStaticDir());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
