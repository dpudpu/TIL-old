package domain.ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {

    @Test
    void move_오른쪽_이동_테스트() {
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.RIGHT);
        Position position = Position.from(0);
        Line line = new Line(directions);

        assertEquals(line.move(position), Position.from(1));
    }

    @Test
    void move_왼쪽_이동_테스트() {
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.STRAIGHT);
        directions.add(Direction.LEFT);
        Position position = Position.from(1);
        Line line = new Line(directions);

        assertEquals(line.move(position), Position.from(0));
    }

    @Test
    void move_직선_이동_테스트() {
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.STRAIGHT);
        Position position = Position.from(0);
        Line line = new Line(directions);

        assertEquals(line.move(position), Position.from(0));
    }

    @Test
    void move_유효범위_밖_예외처리() {
        List<Direction> directions = new ArrayList<>();
        directions.add(Direction.LEFT);
        Position position = Position.from(0);
        Line line = new Line(directions);

        assertThrows(IllegalArgumentException.class, () -> line.move(position));
    }
}
