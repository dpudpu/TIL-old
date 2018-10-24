package practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonExam {
    public static void main(String args[]){
        MiniWasConfiguration miniWasConfiguration = new MiniWasConfiguration();
        miniWasConfiguration.setClassPath("/");
        miniWasConfiguration.setStaticDir("/tmp");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(miniWasConfiguration.toString());
            String str=objectMapper.writeValueAsString(miniWasConfiguration);
            System.out.println(str);

            MiniWasConfiguration miniWasConfiguration1 = objectMapper.readValue(str, MiniWasConfiguration.class);
            System.out.println(miniWasConfiguration1.getClassPath()+"  "+miniWasConfiguration1.getStaticDir());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }




    }
}
