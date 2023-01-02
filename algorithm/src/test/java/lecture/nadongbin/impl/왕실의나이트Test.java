package lecture.nadongbin.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 왕실의나이트Test {

    @Test
    void solution() {
        //given
        왕실의나이트 왕실의나이트 = new 왕실의나이트();

        //when
        int answer = 왕실의나이트.solution("a1");

        //then
        assertThat(answer).isEqualTo(2);
    }
}