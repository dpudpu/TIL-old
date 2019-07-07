package domain.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PositionTest {
    @Test
    void 입력_1이하_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> Position.from(Position.MIN_LENGTH - 1));
    }

    @Test
    void move(){
        Position position = Position.from(2);
        Position actual = Position.from(3);
        assertEquals(position.move(1), actual);
    }
}
