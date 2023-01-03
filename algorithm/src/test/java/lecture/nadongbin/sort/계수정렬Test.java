package lecture.nadongbin.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class 계수정렬Test {

    @Test
    void solution() {
        //given
        계수정렬 계수정렬 = new 계수정렬();

        //when
        int[] answer = 계수정렬.solution(new int[]{7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2});

        //then
        assertThat(answer).isEqualTo(new int[] {0, 0, 1, 1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 9});
    }

}