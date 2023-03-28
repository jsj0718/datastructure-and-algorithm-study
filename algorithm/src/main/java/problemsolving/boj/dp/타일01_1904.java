package problemsolving.boj.dp;

public class 타일01_1904 {
    public int solution(int n) {
        int[] dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        return dp[n];
    }
}
