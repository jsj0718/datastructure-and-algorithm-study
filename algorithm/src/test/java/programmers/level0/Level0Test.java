package programmers.level0;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
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

    @ParameterizedTest
    @MethodSource(value = "겹치는_선분의_길이_데이터")
    void 겹치는_선분의_길이(int[][] lines, int result) {
        //when
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] line : lines) {
            for (int i = Math.min(line[0], line[1]); i < Math.max(line[0], line[1]); i++) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        int[] line = map.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).sorted().mapToInt(Integer::intValue).toArray();

        //then
        assertThat(line.length).isEqualTo(result);
    }

    static Stream<Arguments> 겹치는_선분의_길이_데이터() {
        return Stream.of(
                Arguments.of(new int[][] {{0, 1}, {2, 5}, {3, 9}}, 2),
                Arguments.of(new int[][] {{1, -1}, {1, 3}, {9, 3}}, 0),
                Arguments.of(new int[][] {{0, 5}, {3, 9}, {1, 10}}, 8),
                Arguments.of(new int[][] {{0, 10}, {1, 3}, {5, 8}}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "등수_매기기_데이터")
    void 등수_매기기(int[][] score, int[] result) {
        //when
        int[] answer = new int[score.length];

        int[] sortedScore = Arrays.stream(score).map(ints -> ints[0] + ints[1]).sorted(Comparator.reverseOrder()).distinct().mapToInt(Integer::intValue).toArray();

        int rank = 1;
        for (int i = 0; i < sortedScore.length; i++) {
            int cnt = 0;
            for (int j = 0; j < score.length; j++) {
                int total = score[j][0] + score[j][1];
                if (total == sortedScore[i]) {
                    answer[j] = rank;
                    cnt++;
                }
            }
            rank += cnt;
        }

        //then
        assertThat(answer).contains(result);
    }

    static Stream<Arguments> 등수_매기기_데이터() {
        return Stream.of(
                Arguments.of(new int[][] {{80, 70}, {90, 50}, {40, 70}, {50, 80}}, new int[] {1, 2, 4, 3}),
                Arguments.of(new int[][] {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}}, new int[] {4, 4, 6, 2, 2, 1, 7})
        );
    }
}
