package programmers.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilTest {

    @Test
    void bracketTest() {
        String s = "[[80, 70], [90, 50], [40, 70], [50, 80]]";

        Assertions.assertThat(ArrayUtil.changeBracket(s)).isEqualTo("{{80, 70}, {90, 50}, {40, 70}, {50, 80}}");
    }
}