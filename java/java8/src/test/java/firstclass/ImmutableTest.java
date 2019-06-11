package firstclass;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ImmutableTest {
    @Test
    void name() {
        List<Integer> originList = new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Integer> immutableList = Collections.unmodifiableList(originList);

        originList.add(5);
        immutableList = new ArrayList<>(immutableList);
        immutableList.add(6);

        assertThat(5).isEqualTo(originList.size());
        assertThat(6).isEqualTo(immutableList.size());
    }

//    @Test
//    void some() {
//        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
//        List<Integer> lsit2 = li
//
//    }
}
