package lecture.nadongbin.dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 바닥공사Test {

    @Test
    void solution() {
        //given
        바닥공사 바닥공사 = new 바닥공사();

        //when
        int answer = 바닥공사.solution(3);

        //then
        assertThat(answer).isEqualTo(5);
    }
}