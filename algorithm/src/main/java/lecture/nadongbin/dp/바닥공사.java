package lecture.nadongbin.dp;

public class 바닥공사 {
    public int solution(int n) {
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] * 2 + dp[i - 1];
        }
        return dp[n];
    }
}
