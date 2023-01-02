package lecture.nadongbin.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    @Test
    void solution() {
        //given
        BFS bfs = new BFS();
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(2, 3, 8),
                Arrays.asList(1, 7),
                Arrays.asList(1, 4, 5),
                Arrays.asList(3, 5),
                Arrays.asList(3, 4),
                Arrays.asList(7),
                Arrays.asList(2, 6, 8),
                Arrays.asList(1, 7)
        );

        //when
        List<Integer> answer = bfs.solution(graph, 8);

        //then
        Assertions.assertThat(answer).isEqualTo(Arrays.asList(1, 2, 3, 8, 7, 4, 5, 6));
    }
}