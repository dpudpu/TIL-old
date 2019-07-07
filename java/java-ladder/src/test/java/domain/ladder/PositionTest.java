package domain.ladder;

import domain.ladder.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PositionTest {
    @Test
    void 유효범위_이하_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> Position.from(Position.MIN_RANGE - 1));
    }

    @Test
    void move(){
        Position position = Position.from(2);
        Position actual = Position.from(3);
        assertEquals(position.move(1), actual);
    }
}
