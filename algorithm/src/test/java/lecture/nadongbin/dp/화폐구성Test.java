package lecture.nadongbin.dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 화폐구성Test {


    @Test
    void solution() {
        //given
        화폐구성 화폐구성 = new 화폐구성();

        //when
        int answerV1 = 화폐구성.solution(15, new int[]{2, 3});
        int answerV2 = 화폐구성.solution(4, new int[]{3, 5, 7});

        //then
        Assertions.assertThat(answerV1).isEqualTo(5);
        Assertions.assertThat(answerV2).isEqualTo(-1);
    }
}