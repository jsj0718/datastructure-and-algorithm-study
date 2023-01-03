package lecture.nadongbin.sort.problem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 위에서아래로Test {

    @Test
    void solution() {
        //given
        위에서아래로 위에서아래로 = new 위에서아래로();

        //when
        int[] answer = 위에서아래로.solution(new int[]{15, 27, 12});

        //then
        Assertions.assertThat(answer).isEqualTo(new int[] {27, 15, 12});
    }
}