package lecture.nadongbin.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class 상하좌우Test {

    @Test
    void solutionTest() {
        //given
        int n = 5;
        String plans = "R R R U D D";
        int[] result = {3, 4};
        //when
        상하좌우 상하좌우 = new 상하좌우();
        int[] answer = 상하좌우.solution(n, plans);

        //then
        Assertions.assertThat(answer).isEqualTo(result);
    }
}