package lecture.nadongbin.search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class 미로찾기Test {

    @ParameterizedTest
    @MethodSource("미로찾기_데이터")
    void solution(int n, int m, int[][] graph, int result) {
        //given
        미로찾기 미로찾기 = new 미로찾기();

        //when
        int answer = 미로찾기.solution(n, m, graph);

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 미로찾기_데이터() {
        return Stream.of(
                Arguments.of(5, 6, new int[][]{
                        {1, 0, 1, 0, 1, 0},
                        {1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1}
                }, 10),
                Arguments.of(3, 3, new int[][]{
                        {1, 1, 0},
                        {0, 1, 0},
                        {0, 1, 1},
                }, 5)

        );
    }
}