package lecture.nadongbin.dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

class 피보나치Test {

    @Test
    void solution() {
        //given
        피보나치 피보나치 = new 피보나치();

        //when
        int answerV1 = 피보나치.solutionV1(5);
        int answerV2 = 피보나치.solutionV2(5);
        int answerV3 = 피보나치.solutionV3(5);

        //then
        Assertions.assertThat(answerV1).isEqualTo(5);
        Assertions.assertThat(answerV2).isEqualTo(5);
        Assertions.assertThat(answerV3).isEqualTo(5);
    }
}