package problemsolving.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판_다시_칠하기_1018 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 체스판_다시_칠하기_1018().solution();
    }

    private void solution() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] maps = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = new StringTokenizer(br.readLine()).nextToken().split("");
            for (int j = 0; j < m; j++) {
                maps[i][j] = row[j];
            }
        }

        //logic
        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                String standard = maps[i][j];
                int correctStandardCnt = 0;
                int incorrectStandardCnt = 0;
                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
                            if (maps[x][y].equals(standard)) correctStandardCnt++;
                        } else {
                            if (maps[x][y].equals(standard)) incorrectStandardCnt++;
                        }
                    }
                }
                int sum = Math.min(((32 - correctStandardCnt) + incorrectStandardCnt), ((32 - incorrectStandardCnt) + correctStandardCnt));
                if (result > sum) result = sum;
            }
        }

        System.out.println(result);
    }
}
