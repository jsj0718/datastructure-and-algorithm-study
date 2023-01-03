package lecture.nadongbin.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 퀵정렬Test {

    @Test
    void solution() {
        //given
        퀵정렬 퀵정렬 = new 퀵정렬();

        //when
        int[] answer = 퀵정렬.solution(new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8});

        //then
        assertThat(answer).isEqualTo(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

}