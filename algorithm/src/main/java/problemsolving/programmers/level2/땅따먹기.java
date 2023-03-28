package problemsolving.programmers.level2;

import java.util.Arrays;

public class 땅따먹기 {
    int solution(int[][] land) {
        for (int row = 1; row < land.length; row++) {
            for (int col = 0; col < 4; col++) {
                int max = 0;
                for (int idx = 0; idx < 4; idx++) {
                    if (col == idx) continue;
                    max = Math.max(max, land[row - 1][idx]);
                }
                land[row][col] += max;
            }
        }

        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }

    int solutionV2(int[][] land) {
        int[][] dp = new int[land.length][];
        int rowNum = 0;

        for (int[] row : land) {
            for (int i = 0; i < 4; i++) {
                dp[rowNum][i] = row[i];

                if (rowNum == 0) continue;

                int max = dp[rowNum][i];
                for (int j = 0; j < 4; j++) {
                    if (i == j) continue;
                    int tmp = dp[rowNum][i] + dp[rowNum-1][j];
                    max = Math.max(max, tmp);
                }
                dp[rowNum][i] = max;
            }
            rowNum++;
        }

        return Arrays.stream(dp[rowNum-1]).max().getAsInt();
    }
}
