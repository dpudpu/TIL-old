package domain.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {
    @Test
    void RIGHT_move() {
        Direction direction = Direction.RIGHT;
        assertEquals(direction.move(), 1);
    }

    @Test
    void LEFT_move() {
        Direction direction = Direction.LEFT;
        assertEquals(direction.move(), -1);
    }

    @Test
    void STRAIGHT_move() {
        Direction direction = Direction.STRAIGHT;
        assertEquals(direction.move(), 0);
    }

    @Test
    void first_true() {
        assertEquals(Direction.first(true), Direction.RIGHT);
    }

    @Test
    void first_false() {
        assertEquals(Direction.first(false), Direction.STRAIGHT);
    }

    @Test
    void last_STRAIGHT1() {
        Direction direction = Direction.STRAIGHT;
        assertEquals(direction.last(), Direction.STRAIGHT);
    }

    @Test
    void last_STRAIGHT2() {
        Direction direction = Direction.LEFT;
        assertEquals(direction.last(), Direction.STRAIGHT);
    }

    @Test
    void last_LEFT(){
        Direction direction = Direction.RIGHT;
        assertEquals(direction.last(), Direction.LEFT);
    }

    @Test
    void LEFT_next_true() {
        Direction direction = Direction.LEFT;
        assertEquals(direction.next(true), Direction.RIGHT);
    }

    @Test
    void LEFT_next_false() {
        Direction direction = Direction.LEFT;
        assertEquals(direction.next(false), Direction.STRAIGHT);
    }

    @Test
    void RIGHT_next_true() {
        Direction direction = Direction.RIGHT;
        assertEquals(direction.next(true), Direction.LEFT);
    }

    @Test
    void RIGHT_next_false() {
        Direction direction = Direction.RIGHT;
        assertEquals(direction.next(false), Direction.LEFT);
    }

    @Test
    void STRAIGHT_next_true() {
        Direction direction = Direction.STRAIGHT;
        assertEquals(direction.next(true), Direction.RIGHT);
    }

    @Test
    void STRAIGHT_next_false() {
        Direction direction = Direction.STRAIGHT;
        assertEquals(direction.next(false), Direction.STRAIGHT);
    }
}
