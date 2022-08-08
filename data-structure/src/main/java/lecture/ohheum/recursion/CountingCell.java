package lecture.ohheum.recursion;

public class CountingCell {
    private static int N = 8;
    private static int[][] blob = {
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1, 1},
    };

    // private static final int BACKGROUND_PIXEL = 0;
    private static final int IMAGE_PIXEL = 1;
    private static final int VISITED_PIXEL = 2;
    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    private static int total = 0;

    public static void main(String[] args) {
        printBlob();
        System.out.println(countCell(1, 5));
        printBlob();
    }

    private static void printBlob() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(blob[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int countCell(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return 0;
        } else if (blob[x][y] != IMAGE_PIXEL) {
            return 0;
        } else {
            blob[x][y] = VISITED_PIXEL;
            total++;
            for (int[] d : DIRECTIONS) {
                countCell(x + d[0], y + d[1]);
            }
            return total;
        }
    }

}
