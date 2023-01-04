package lecture.nadongbin.search.problem;

import lecture.nadongbin.search.problem.음료수얼려먹기;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class 음료수얼려먹기Test {

    @ParameterizedTest
    @MethodSource(value = "음료수얼려먹기_데이터")
    void solution(int n, int m, int[][] graph, int result) {
        //given
        음료수얼려먹기 음료수얼려먹기 = new 음료수얼려먹기();

        //when
        int answer = 음료수얼려먹기.solution(n, m, graph);

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 음료수얼려먹기_데이터() {
        return Stream.of(
                Arguments.of(4, 5, new int[][] {
                {0,0,1,1,0},
                {0,0,0,1,1},
                {1,1,1,1,1},
                {0,0,0,0,0}}, 3),
                Arguments.of(15, 14, new int[][] {
                {0,0,0,0,0,1,1,1,1,0,0,0,0,0},
                {1,1,1,1,1,1,0,1,1,1,1,1,1,0},
                {1,1,0,1,1,1,0,1,1,0,1,1,1,0},
                {1,1,0,1,1,1,0,1,1,0,0,0,0,0},
                {1,1,0,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,0,1,1,1,1,1,1,1,1,1,0,0},
                {1,1,0,0,0,0,0,0,0,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0,0,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1,1,0,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,1,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,0,0,1,1},
                {1,1,1,0,0,0,1,1,1,1,1,1,1,1},
                {1,1,1,0,0,0,1,1,1,1,1,1,1,1}}, 8)
        );
    }

}