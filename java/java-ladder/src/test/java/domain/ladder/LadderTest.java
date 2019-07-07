package domain.ladder;

import domain.game.Result;
import domain.player.Player;
import domain.player.Players;
import domain.reward.Reward;
import domain.reward.Rewards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    Ladder ladder;

    @BeforeEach
    void setUp() {
        List<Line> lines = new ArrayList<>();
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.RIGHT);
        directions.add(Direction.LEFT);
        lines.add(new Line(directions));

        directions = new ArrayList<>();
        directions.add(Direction.RIGHT);
        directions.add(Direction.LEFT);
        lines.add(new Line(directions));
        ladder = new Ladder(lines);
    }

    @Test
    void null_예외처리() {
        assertThrows(NullPointerException.class, () -> new Ladder(null));
    }

    @Test
    void Lines_유효범위_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(new ArrayList<>()));
    }

    @Test
    void Players와_Rwards_사이즈가_다를때() {
        Players players = new Players("1, 2, 3");
        Rewards rewards = new Rewards("1,2,3,4");
        assertThrows(IllegalArgumentException.class, () -> ladder.createResult(players, rewards));
    }

    @Test
    void createResultTest() {
        Players players = new Players("1, 2");
        Rewards rewards = new Rewards("1, 2");

        Map<Player, Reward> map = new HashMap<>();
        map.put(new Player("1"), new Reward("1"));
        map.put(new Player("2"), new Reward("2"));
        Result actual = new Result(map);

        Result expected = ladder.createResult(players, rewards);
        assertEquals(expected, actual);
    }

    @Test
    void Result_생성_테스트() {

    }
}
