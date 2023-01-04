package lecture.nadongbin.search.problem;

import java.util.LinkedList;
import java.util.Queue;

public class 미로찾기 {
    public int solution(int n, int m, int[][] graph) {
        bfs(graph,0, 0);
        return graph[n-1][m-1];
    }

    public void bfs(int[][] graph, int x, int y) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            x = node[0];
            y = node[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < graph.length && ny >= 0 && ny < graph[0].length
                        && graph[nx][ny] == 1) {
                    graph[nx][ny] += graph[x][y];
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
}
