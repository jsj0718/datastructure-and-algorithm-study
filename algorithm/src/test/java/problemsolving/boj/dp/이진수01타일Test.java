package problemsolving.boj.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 이진수01타일Test {

    @Test
    void solution() {
        //given
        타일01_1904 instance = new 타일01_1904();

        //when
        int answer = instance.solution(4);

        //then
        assertEquals(5, answer);
    }
}