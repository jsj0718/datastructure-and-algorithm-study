package lecture.nadongbin.search.problem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class 부품찾기Test {

    @Test
    void solution() {
        //given
        부품찾기 부품찾기 = new 부품찾기();

        //when
        String[] answerV1 = 부품찾기.solutionV1(5, new int[]{8, 3, 7, 9, 2}, 3, new int[]{5, 7, 9});
        String[] answerV2 = 부품찾기.solutionV2(5, new int[]{8, 3, 7, 9, 2}, 3, new int[]{5, 7, 9});
        String[] answerV3 = 부품찾기.solutionV3(5, new int[]{8, 3, 7, 9, 2}, 3, new int[]{5, 7, 9});

        //then
        Assertions.assertThat(answerV1).isEqualTo(new String[]{"no", "yes", "yes"});
        Assertions.assertThat(answerV2).isEqualTo(new String[]{"no", "yes", "yes"});
        Assertions.assertThat(answerV3).isEqualTo(new String[]{"no", "yes", "yes"});
    }
}