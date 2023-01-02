package lecture.nadongbin.impl;

public class 게임개발 {
    public int solution(int n, int m, int[] pos, int[][] maps) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int row = pos[0];
        int col = pos[1];
        int dir = pos[2];

        boolean[][] visited = new boolean[n][m];
        visited[row][col] = true;

        int answer = 1;
        int turnTime = 0;

        while (true) {
            int nextRow = row + dirs[dir][0];
            int nextCol = col + dirs[dir][1];

            if (nextRow >= 0 && nextRow <= n && nextCol >= 0 && nextCol <= m
                    && maps[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                visited[nextRow][nextCol] = true;
                row = nextRow;
                col = nextCol;
                answer++;
                turnTime = 0;
                continue;
            } else {
                turnTime++;
                dir = (dir - 1 < 0) ? 3 : dir - 1;
            }

            if (turnTime == 4) {
                nextRow = row - dirs[dir][0];
                nextCol = col - dirs[dir][1];
                if (maps[nextRow][nextCol] == 1) break;

                row = nextRow;
                col = nextCol;
                turnTime = 0;
            }
        }

        return answer;
    }
}
