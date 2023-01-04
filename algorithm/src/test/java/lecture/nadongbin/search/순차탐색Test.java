package lecture.nadongbin.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 순차탐색Test {

    @Test
    void solution() {
        //given
        순차탐색 순차탐색 = new 순차탐색();

        //when
        int answer = 순차탐색.sequentialSearch(new String[]{"하늘", "종구", "동빈", "태일", "상욱"}, "동빈");

        //then
        Assertions.assertThat(answer).isEqualTo(3);
    }
}