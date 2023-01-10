package lecture.nadongbin.dp;

public class 숫자1로만들기 {
    public int solution(int n) {
        int[] dp = new int[30001];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if (i % 5 == 0) dp[i] = Math.min(dp[i], dp[i / 5] + 1);
        }

        return dp[n];
    }
}
