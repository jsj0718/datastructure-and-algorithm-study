package programmers.level0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Level0Test {

    @ParameterizedTest
    @MethodSource(value = "삼각형_완성조건_2_데이터")
    @DisplayName("삼각형 완성조건 - 가장 긴 변의 길이는 다른 두 변의 길이 합보다 작아야 한다.")
    void 삼각형_완성조건_2(int[] sides, int result) {
        assertThat(Math.min(sides[0], sides[1]) * 2 - 1).isEqualTo(result);
    }

    static Stream<Arguments> 삼각형_완성조건_2_데이터() {
        return Stream.of(
                Arguments.of(new int[] {1, 2}, 1),
                Arguments.of(new int[] {3, 6}, 5),
                Arguments.of(new int[]{11, 7}, 13)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "OX퀴즈_데이터")
    @DisplayName("OX퀴즈 - 수식이 옳으면 O, 아니면 X")
    void OX퀴즈(String[] quiz, String[] result) {
        //when
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            Queue<String> q = new LinkedList<>();
            for (String token : quiz[i].split(" ")) {
                q.add(token);
            }

            int tmp = 0;
            boolean flag = false;
            while (!q.isEmpty()) {
                String s = q.poll();
                if (s.equals("+")) tmp += Integer.valueOf(q.poll());
                else if (s.equals("-")) tmp -= Integer.valueOf(q.poll());
                else if (s.equals("=")) flag = (tmp == Integer.valueOf(q.poll()));
                else tmp = Integer.valueOf(s);
            }
            answer[i] = (flag) ? "O" : "X";
        }

        //then
        assertThat(answer).contains(result);
    }

    static Stream<Arguments> OX퀴즈_데이터() {
        return Stream.of(
                Arguments.of(new String[] {"3 - 4 = -3", "5 + 6 = 11"}, new String[] {"X", "O"}),
                Arguments.of(new String[] {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"}, new String[] {"O", "O", "X", "O"})
        );
    }

    @ParameterizedTest
    @MethodSource(value = "안전지대_데이터")
    @DisplayName("안전지대 - 지뢰 주변 위험처리 후 나머지 칸 계산")
    void 안전지대(int[][] board, int result) {
        //when
        int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {0, 0}};
        int[][] visited = new int[board.length][board.length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    for (int[] d : direction) {
                        int ni = i + d[0];
                        int nj = j + d[1];
                        if (ni > -1 && ni < board.length && nj > -1 && nj < board.length) {
                            visited[ni][nj] = 1;
                        }
                    }
                }
            }
        }

        int answer = (int) Arrays.stream(visited).flatMapToInt(ints -> Arrays.stream(ints)).filter(i -> i == 0).count();

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 안전지대_데이터() {
        return Stream.of(
                Arguments.of(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}}, 16),
                Arguments.of(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}}, 13)
        );
    }
}
