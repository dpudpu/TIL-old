package domain.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    @Test
    void 이름_유효범위_초과_예외처리() {
        String name = "123456";
        assertThrows(IllegalArgumentException.class, () -> new Player(name));
    }

    @Test
    void NULL_예외처리() {
        assertThrows(NullPointerException.class, () -> new Player(null));
    }

    @Test
    void 공백_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new Player(""));
    }

    @Test
    void 논리적_동치성_확인() {
        String name = "abc";
        assertTrue(new Player(name).equals(new Player(name)));
    }
}
