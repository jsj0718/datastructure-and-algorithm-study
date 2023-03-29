package problemsolving.boj.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좌표_정렬하기_11650 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 좌표_정렬하기_11650().solutionV1();
    }

    /**
     * x -> y 순으로 정렬
     */
    private void solutionV1() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] coordinate = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                coordinate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //logic
        int[][] sortedCoordinate = Arrays.stream(coordinate).sorted((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        }).toArray(int[][]::new);

        for (int[] result : sortedCoordinate) {
            System.out.println(result[0] + " " + result[1]);
        }
    }

    /**
     * y -> x 순으로 정렬
     */
    private void solutionV2() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] coordinate = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                coordinate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //logic
        int[][] sortedCoordinate = Arrays.stream(coordinate).sorted((o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        }).toArray(int[][]::new);

        for (int[] result : sortedCoordinate) {
            System.out.println(result[0] + " " + result[1]);
        }
    }
}
