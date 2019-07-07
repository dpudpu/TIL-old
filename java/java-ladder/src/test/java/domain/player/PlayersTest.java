package domain.player;

import domain.ladder.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {
    @Test
    void 쉼표_외_입력시_예외처리() {
        String playerNames = "pobi. crong, bedi";
        assertThrows(IllegalArgumentException.class, ()-> new Players(playerNames));
    }

    @Test
    void 사이즈_확인(){
        String playerNames = "pobi, crong, bedi";
        Players players = new Players(playerNames);

        assertEquals(players.size(), 3);
    }

    @Test
    void getTest(){
        String playerNames = "pobi, crong, bedi";
        Players players = new Players(playerNames);

        Position position = Position.from(2);
        Player actual = new Player("bedi");
        assertEquals(players.get(position), actual);
    }
}
