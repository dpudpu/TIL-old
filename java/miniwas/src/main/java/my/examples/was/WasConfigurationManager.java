package my.examples.was;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

// 싱글패턴
public class WasConfigurationManager {
    private ObjectMapper objectMapper;

    // 2. 자기 자신을 참조하는 private static변수를 선언한다.
    //    static한 변수는 딱한번 초기화되고, 메모리에 딱 한번만 올라간다.
    private static WasConfigurationManager instance = new WasConfigurationManager();

    // 1. private 생성자를 만든다.
    private WasConfigurationManager(){
        objectMapper = new ObjectMapper();
    }

    // 3. public static 한 메소드를 만든다. instance를 리턴하는...
    public static WasConfigurationManager getInstance(){
        return instance;
    }

    public void saveMiniWasConfiguration(MiniWasConfiguration miniWasConfiguration, String fileName)
        throws RuntimeException{
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(fileName), miniWasConfiguration);
        }catch(Exception ex){
            throw new RuntimeException("파일 저장이 안됩니다!!!!!!");
        }

    }

    public MiniWasConfiguration getMiniWasConfiguration(String fileName){
        try {
            MiniWasConfiguration readObj =
                    objectMapper.readValue(new File(fileName), MiniWasConfiguration.class);
            return readObj;
        }catch(Exception ex){
            return null;
        }
    }
}

// WasConfigurationManager wasConfigurationManager = new WasConfigurationManager();
// WasConfigurationManager wcm1 = WasConfigurationManager.getInstance();
// WasConfigurationManager wcm2 = WasConfigurationManager.getInstance();
