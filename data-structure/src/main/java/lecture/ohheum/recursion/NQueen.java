package lecture.ohheum.recursion;

public class NQueen {
    public static int N = 8;
    public static int[] cols = new int[N+1];

    public static void main(String[] args) {
        queensV1(0);
        System.out.println(queensV2(0));
    }
    
    private static boolean queensV1(int level) {
        if (!isPossible(level)) {
            return false;
        } else if (level == N) {
            printChess();
            return true;
        } else {
            for (int i = 1; i <= N; i++) {
                cols[level + 1] = i;
                if (queensV1(level + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static int queensV2(int level) {
        int result = 0;
        if (!isPossible(level)) {
            return 0;
        }
        else if (level == N) {
            return 1;
        } else {
            for (int i = 1; i <= N; i++) {
                cols[level + 1] = i;
                result += queensV2(level + 1);
            }
            return result;
        }
    }

    private static void printChess() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cols[i] == j) {
                    System.out.print("V");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    private static boolean isPossible(int level) {
        for (int i = 1; i < level; i++) {
            if (cols[i] == cols[level]) {
                return false;
            } else if ((level - i) == Math.abs(cols[level] - cols[i])) {
                return false;
            }
        }

        return true;
    }
}
