package lecture.nadongbin.impl;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class 게임개발Test {

    @Test
    void solution() {
        //given
        게임개발 게임개발 = new 게임개발();

        //when
        int answer = 게임개발.solution(4, 4, new int[]{1, 1, 0},
                new int[][]{{1, 1, 1, 1}, {1, 0, 0, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}});

        //then
        assertThat(answer).isEqualTo(3);
    }
}