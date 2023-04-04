package problemsolving.boj.combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기_1010 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 다리놓기_1010().solution();
    }

    private void solution() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int[][] params = new int[t][2];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            params[i][0] = Integer.parseInt(st.nextToken());
            params[i][1] = Integer.parseInt(st.nextToken());
        }

        //logic
        for (int i = 0; i < t; i++) {
            long result = 1;

            int r = params[i][0];
            int n = params[i][1];
            for (int j = 1; j <= r; j++) {
                result = result * (n - j + 1) / j;
            }

            System.out.println(result);

        }
    }
}
