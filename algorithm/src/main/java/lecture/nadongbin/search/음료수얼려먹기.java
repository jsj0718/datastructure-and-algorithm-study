package lecture.nadongbin.search;

import java.util.LinkedList;
import java.util.Queue;

public class 음료수얼려먹기 {
    public int solution(int n, int m, int[][] graph) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    answer++;
                    bfs(i, j, graph);
                }
            }
        }

        return answer;
    }

    public void bfs(int x, int y, int[][] graph) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            graph[row][col] = 1;
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < graph.length && newCol >= 0 && newCol < graph[0].length
                        && graph[newRow][newCol] != 1) {
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }
}
