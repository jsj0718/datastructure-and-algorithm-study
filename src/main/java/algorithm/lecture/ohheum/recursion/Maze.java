package algorithm.lecture.ohheum.recursion;

public class Maze {
    private static int N = 8;
    private static int[][] maze = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0},
    };

    private static final int PATHWAY_COLOR = 0; //white
    private static final int WALL_COLOR = 1; //blue
    private static final int BLOCKED_COLOR = 2; //red (visited이며 출구까지 경로가 없는 셀)
    private static final int PATH_COLOR = 3; //green (visited이며 출구 가능성이 있는 셀)

    public static void main(String[] args) {
        printMaze();
        System.out.println(findPath(0, 0));
        printMaze();
    }

    private static void printMaze() {
        for (int[] i : maze) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean findPath(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        } else if (maze[x][y] != PATHWAY_COLOR) {
            return false;
        } else if (x == N - 1 && y == N - 1) {
            maze[x][y] = PATH_COLOR;
            return true;
        } else {
            maze[x][y] = PATH_COLOR;
            if (findPath(x, y-1) || findPath(x, y+1) || findPath(x-1, y) || findPath(x+1, y)) {
                return true;
            }
            maze[x][y] = BLOCKED_COLOR;
            return false;
        }
    }

}
