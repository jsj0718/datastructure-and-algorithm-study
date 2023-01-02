package lecture.nadongbin.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DFSTest {

    @Test
    void solution() {
        //given
        DFS dfs = new DFS();
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
        List<Integer> answer = dfs.solution(graph, 8);

        //then
        Assertions.assertThat(answer).isEqualTo(Arrays.asList(1, 2, 7, 6, 8, 3, 4, 5));
    }
}