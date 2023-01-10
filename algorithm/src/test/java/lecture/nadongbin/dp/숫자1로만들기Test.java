package lecture.nadongbin.dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 숫자1로만들기Test {

    @Test
    void solution() {
        //given
        int n = 26;
        숫자1로만들기 숫자1로만들기 = new 숫자1로만들기();

        //when
        int answer = 숫자1로만들기.solution(n);

        //then
        Assertions.assertThat(answer).isEqualTo(3);
    }
}