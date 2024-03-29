package programmers.level1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Level1Test {

    @ParameterizedTest
    @MethodSource(value = "크레인_인형뽑기_게임_데이터")
    void 크레인_인형뽑기_게임(int[][] board, int[] moves, int result) {
        //when
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            int height = 0;
            while (true) {
                int item = board[height][move-1];
                if (item != 0) {
                    if (!stack.isEmpty() && item == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    }
                    else stack.push(item);
                    board[height][move-1] = 0;
                    break;
                }
                if (++height == board.length) break;
            }
        }

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 크레인_인형뽑기_게임_데이터() {
        return Stream.of(
                Arguments.of(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[] {1,5,3,5,1,2,1,4}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "삼총사_데이터")
    @DisplayName("배열 중 세 정수를 더해서 0이 되면 삼총사")
    void 삼총사(int[] number, int result) {
        //when
        int answer = 0;

        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }

        //then
        assertThat(answer).isEqualTo(result);
    }

    static Stream<Arguments> 삼총사_데이터() {
        return Stream.of(
                Arguments.of(new int[] {-2, 3, 0, 2, -5}, 2),
                Arguments.of(new int[] {-3, -2, -1, 0, 1, 2, 3}, 5),
                Arguments.of(new int[] {-1, 1, -1, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "최소직사각형_데이터")
    void 최소직사각형(int[][] sizes, int result) {
        //when
        int height = IntStream.range(0, sizes.length).map(i -> Math.min(sizes[i][0], sizes[i][1])).max().getAsInt();
        int width = Arrays.stream(sizes).flatMapToInt(arrays -> Arrays.stream(arrays)).max().getAsInt();

        //then
        assertThat(height * width).isEqualTo(result);
    }
    
    static Stream<Arguments> 최소직사각형_데이터() {
        return Stream.of(
                Arguments.of(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}, 4000),
                Arguments.of(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}, 120),
                Arguments.of(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}, 133)
        );
    }
}
