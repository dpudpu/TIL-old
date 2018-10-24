package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class DiceConfig {
    @Bean
    public Dice dice(){
        System.out.println("dice()");
        return new Dice(6);
    }
//    @Bean
//    public Player kim(Dice dice){
//        Player player = new Player();
//        player.setDice(dice);
//        player.setName("kim");
//        return player;
//    }
//    @Bean
//    public Game game(){
//        Game game = new Game();
//        List<Player> list = new ArrayList();
//        list.add(kim(dice()));
//        game.setPlayerList(list);
//        return game;
//    }
}
