package lecture.nadongbin.greedy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 숫자1이될때까지Test {

    @ParameterizedTest
    @CsvSource(value = {"25, 5, 2", "17, 4, 3"})
    void solutionTest(int n, int k, int result) {
        //when
        숫자1이될때까지 숫자1이될때까지 = new 숫자1이될때까지();

        //then
        int answer = 숫자1이될때까지.solution(n, k);
        assertEquals(result, answer);
    }
}