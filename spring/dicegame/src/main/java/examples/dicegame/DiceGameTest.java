package examples.dicegame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiceGameTest {
    public static void main(String args[]){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dice.xml");
        Game game = applicationContext.getBean(Game.class);
        game.play();

    }
}
