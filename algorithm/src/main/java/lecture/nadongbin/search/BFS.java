package lecture.nadongbin.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public List<Integer> solution(List<List<Integer>> graph, int n) {
        List<Integer> result = new ArrayList<>();
        bfs(graph, new boolean[n], 1, result);
        return result;
    }

    public void bfs(List<List<Integer>> graph, boolean[] visited, int start, List<Integer> result) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start - 1] = true;
        result.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer nextNode : graph.get(node - 1)) {
                if (visited[nextNode - 1]) continue;
                visited[nextNode - 1] = true;
                result.add(nextNode);
                queue.add(nextNode);
            }
        }
    }
}
