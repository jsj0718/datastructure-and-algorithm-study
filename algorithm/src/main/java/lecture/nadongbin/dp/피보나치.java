package lecture.nadongbin.dp;

public class 피보나치 {
    public int solutionV1(int n) {
        return fiboV1(n);
    }

    private int fiboV1(int n) {
        if (n < 2) return n;
        return fiboV1(n - 1) + fiboV1(n - 2);
    }

    public int solutionV2(int n) {
        int[] dp = new int[n + 1];
        return fiboV2(dp, n);
    }

    //탑다운
    private int fiboV2(int[] dp, int n) {
        if (n < 2) return n;

        if (dp[n] != 0) return dp[n];

        dp[n] = fiboV2(dp, n - 1) + fiboV2(dp, n - 2);
        return dp[n];
    }

    public int solutionV3(int n) {
        return fiboV3(n);
    }

    //바텀업
    private int fiboV3(int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) dp[i] = 1;
            else dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
