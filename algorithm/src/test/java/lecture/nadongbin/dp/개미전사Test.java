package lecture.nadongbin.dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 개미전사Test {

    @Test
    void solution() {
        //given
        int[] array = {1, 3, 1, 5, 3};
        개미전사 개미전사 = new 개미전사();

        //when
        int answer = 개미전사.solution(array);

        //then
        Assertions.assertThat(answer).isEqualTo(8);
    }
}