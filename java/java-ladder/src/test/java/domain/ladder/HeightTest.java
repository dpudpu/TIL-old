package domain.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class HeightTest {
    @Test
    void 입력_1이하_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new Height(0));
    }
}
