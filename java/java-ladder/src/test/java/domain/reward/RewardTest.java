package domain.reward;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardTest {
    @Test
    void 이름_유효범위_초과_예외처리() {
        String name = "123456";
        assertThrows(IllegalArgumentException.class, () -> new Reward(name));
    }

    @Test
    void 논리적_동치성_테스트() {
        String name = "꽝";
        assertEquals(new Reward(name), new Reward(name));
    }
}
