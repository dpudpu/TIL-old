package my.examples.was;

public class WasConfigurationManagerTest {
    public static void main(String[] args){
        WasConfigurationManager wcm =
                WasConfigurationManager.getInstance();
        WasConfigurationManager wcm2 =
                WasConfigurationManager.getInstance();

        if(wcm == wcm2){
            System.out.println("같은 참조입니다.");
        }

        MiniWasConfiguration miniWasConfiguration =
                new MiniWasConfiguration();
        miniWasConfiguration.setStaticDir("/tmp/www");
        miniWasConfiguration.setClassPath(".");

        wcm.saveMiniWasConfiguration(miniWasConfiguration, "/tmp/m.json");

        MiniWasConfiguration mwc = wcm.getMiniWasConfiguration("/tmp/m.json");
        System.out.println(mwc.getStaticDir());
        System.out.println(mwc.getClassPath());
    }
}
