package lecture.nadongbin.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 큰수의법칙Test {

    @Test
    void solutionTest() {
        //given
        큰수의법칙 큰수의법칙 = new 큰수의법칙();

        //when
        int answer = 큰수의법칙.solution(5, 8, 3, new int[]{2, 4, 5, 4, 6});

        //then
        assertThat(answer).isEqualTo(46);
    }
}