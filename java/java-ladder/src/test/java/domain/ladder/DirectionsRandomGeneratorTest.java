package domain.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionsRandomGeneratorTest {
    @Test
    void 생성_사이즈_확인() {
        DirectionsGenerator directionsGenerator = DirectionsRandomGenerator.getInstance();
        int size = 5;
        int expected = directionsGenerator.generate(size).size();
        assertEquals(expected, size);
    }
}
