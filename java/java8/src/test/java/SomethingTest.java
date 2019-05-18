import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class SomethingTest {
    List<Integer> list1;
    List<Integer> list2;

    @BeforeEach
    void setUp() {
        list1 = Arrays.asList(1, 2, 3);
        list2 = new ArrayList<>(list1);
    }

    @Test
    void test01() {
        list2.add(1);
        list2.add(1);
        list2.add(1);

        assertEquals(3, list1.size());
        assertEquals(6, list2.size());
    }

    @Test
    void test02() {
        list1=list2;
        list2.add(1);
        list1.add(1);

        assertEquals(5, list1.size());
        assertEquals(5, list2.size());
    }
}
