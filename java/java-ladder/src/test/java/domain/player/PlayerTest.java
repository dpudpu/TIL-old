package domain.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PlayerTest {
    @Test
    void PlayerName_같은_경우_논리적_동치성_테스트() {
        assertEquals(new Player(1,"pobi"), new Player(2,"pobi"));
    }

    @Test
    void Position_같은_경우_논리적_동치성_테스트() {
        assertNotEquals(new Player(1,"crong"), new Player(1,"pobi"));
    }
}
