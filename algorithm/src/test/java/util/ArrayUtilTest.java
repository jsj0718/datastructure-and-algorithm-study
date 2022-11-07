package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import util.ArrayUtil;

class ArrayUtilTest {

    @Test
    void bracketTest() {
        String s = "[[80, 70], [90, 50], [40, 70], [50, 80]]";

        Assertions.assertThat(ArrayUtil.changeBracket(s)).isEqualTo("{{80, 70}, {90, 50}, {40, 70}, {50, 80}}");
    }

    @Test
    void transBracket() {
        System.out.println(ArrayUtil.changeBracket("[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]"));
    }
}