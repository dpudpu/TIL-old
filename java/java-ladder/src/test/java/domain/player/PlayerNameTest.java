package domain.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerNameTest {
    @Test
    void 이름_5글자_초과() {
        String name = "123456";
        assertThrows(IllegalArgumentException.class, () -> new PlayerName(name));
    }

    @Test
    void NULL_예외처리() {
        assertThrows(NullPointerException.class, () -> new PlayerName(null));
    }

    @Test
    void 공백_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerName(""));
    }

    @Test
    void 논리적_동치성_확인() {
        String name = "abc";
        assertTrue(new PlayerName(name).equals(new PlayerName(name)));
    }
}
