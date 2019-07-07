package domain.game;

import domain.player.Player;
import domain.reward.Reward;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ResultTest {
    @Test
    void 반환_테스트() {
        Map<Player, Reward> map = new HashMap<>();
        final Player player = new Player("pobi");
        final Reward reward = new Reward("꽝");
        map.put(player, reward);
        Result result = new Result(map);

        assertEquals(result.get(player.getName()), reward);
    }

    @Test
    void 전체_반환_테스트() {
        Map<Player, Reward> map = new HashMap<>();
        final Player player = new Player("pobi");
        final Reward reward = new Reward("꽝");
        map.put(player, reward);
        map.put(new Player("crong"), reward);
        Result result = new Result(map);

        assertEquals(map, result.getAll());
        assertFalse(map == result.getAll());
    }
}
