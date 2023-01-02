package lecture.nadongbin.search;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public List<Integer> solution(List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();
        dfs(graph, visited, 1, result);
        return result;
    } 
    
    public void dfs(List<List<Integer>> graph, boolean[] visited, int x, List<Integer> result) {
        result.add(x);
        visited[x - 1] = true;
        for (Integer node : graph.get(x - 1)) {
            if (visited[node - 1]) continue;
            dfs(graph, visited, node, result);
        }
    }
}
