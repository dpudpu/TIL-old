package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExam05 {
    public static void main(String args[]) throws Exception{
        // xml 대신 java config 읽음
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DiceConfig.class);
//        Dice dice = context.getApplicationName();
        Game game = applicationContext.getBean("game", Game.class);
        game.play();

    }
}
