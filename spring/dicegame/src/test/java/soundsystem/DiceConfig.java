package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

// Spring은 @Configuration 붙어있는 클래스를 Java Config로 인식한다.
@Configuration
public class DiceConfig {
    /*
    빈을 생성하는 메소드에는 @Bean 애노테이션이 붙는다.
    메소드 이름이 id값이 된다.
    <bean id="dice" class="soundsystem.Dice">
        <constructor-arg value="6"/>
    </bean>
     */
    @Bean
    public Dice dice(){
        System.out.println("dice() --------------------------");
        return new Dice(6);
    }

    /*
    스프링 컨테이너가 kim이란 메소드를 호출하는데 파라미터로 Dice객체를 자동으로 넣어준다.
     */
    @Bean
    public Player kim(){
        System.out.println("kim()");
        System.out.println(this.getClass().getName());
        Player player = new Player();
        player.setDice(dice());
        player.setName("kim");
        return player;
    }

    @Bean
    public Player kang(){
        System.out.println("kang()");
        Player player = new Player();
        player.setDice(dice());
        player.setName("kang");
        return player;
    }

    @Bean
    public Player lee(){
        System.out.println("lee()");
        Player player = new Player();
        player.setDice(dice());
        player.setName("lee");
        return player;
    }

    @Bean
    public Game game(){
        Game game = new Game();
        List<Player> list = new ArrayList<>();
        list.add(kim());
        list.add(kang());
        list.add(lee());
        game.setPlayerList(list);
        return game;
    }
}
