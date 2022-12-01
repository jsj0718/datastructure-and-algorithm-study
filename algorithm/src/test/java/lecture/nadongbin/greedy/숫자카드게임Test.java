package lecture.nadongbin.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class 숫자카드게임Test {

    @ParameterizedTest
    @MethodSource(value = "숫자카드게임_데이터")
    void solutionTest(int n, int m, int[][] cards, int result) {
        //when
        숫자카드게임 숫자카드게임 = new 숫자카드게임();

        //then
        int answer = 숫자카드게임.solution(n, m, cards);
        Assertions.assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 숫자카드게임_데이터() {
        return Stream.of(
                Arguments.of(3, 3, new int[][] {{3, 1, 2}, {4, 1, 4}, {2, 2, 2}}, 2),
                Arguments.of(2, 4, new int[][] {{7, 3, 1, 8}, {3, 3, 3, 4}}, 3)
        );
    }
}