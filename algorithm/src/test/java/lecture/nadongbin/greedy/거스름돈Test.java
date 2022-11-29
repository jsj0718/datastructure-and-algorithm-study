package lecture.nadongbin.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 거스름돈Test {

    @Test
    void solutionTest() {
        //given
        거스름돈 거스름돈 = new 거스름돈();

        //when
        int answer = 거스름돈.solution(1260);

        //then
        assertThat(answer).isEqualTo(6);
    }
}