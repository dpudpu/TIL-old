package domain.reward;

import domain.ladder.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardsTest {
    @Test
    void 쉼표_외_입력시_예외처리() {
        String rewardNames = "꽝! 1000, 2000";
        assertThrows(IllegalArgumentException.class, ()-> new Rewards(rewardNames));
    }

    @Test
    void 사이즈_확인(){
        String rewardNames = "꽝, 1000, 2000";
        Rewards rewards = new Rewards(rewardNames);

        assertEquals(rewards.size(), 3);
    }

    @Test
    void getTest(){
        String rewardNames = "꽝, 1000, 2000";
        Rewards rewards = new Rewards(rewardNames);

        Position position = Position.from(2);
        Reward actual = new Reward("2000");
        assertEquals(rewards.get(position), actual);
    }
}
