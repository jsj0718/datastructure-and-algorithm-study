package lecture.nadongbin.sort.problem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class 두배열의원소교체Test {

    @Test
    void solution() {
        //given
        두배열의원소교체 두배열의원소교체 = new 두배열의원소교체();

        //when
        int answer = 두배열의원소교체.solution(5, 3, new int[]{1, 2, 5, 4, 3}, new int[]{5, 5, 6, 6, 5});

        //then
        Assertions.assertThat(answer).isEqualTo(26);
    }
}