package lecture.nadongbin.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 시각Test {

    @Test
    void solution() {
        //given
        시각 시각 = new 시각();

        //when
        int answer = 시각.solution(5);

        //then
        Assertions.assertThat(answer).isEqualTo(11475);
    }
}