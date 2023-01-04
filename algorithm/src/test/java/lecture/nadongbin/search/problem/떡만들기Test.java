package lecture.nadongbin.search.problem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 떡만들기Test {

    @Test
    void solution() {
        //given
        떡만들기 떡만들기 = new 떡만들기();

        //when
        int answer = 떡만들기.solution(4, 6, new int[]{19, 15, 10, 17});

        //then
        Assertions.assertThat(answer).isEqualTo(15);
    }
}