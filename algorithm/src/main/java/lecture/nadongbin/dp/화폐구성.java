package lecture.nadongbin.dp;

import java.util.stream.IntStream;

public class 화폐구성 {
    public int solution(int total, int[] moneys) {
        int[] dp = IntStream.rangeClosed(1, 10001).mapToObj(i -> i = 10001).mapToInt(Integer::intValue).toArray();
        dp[0] = 0;

        for (int money : moneys) {
            for (int i = money; i <= total; i++) {
                if (dp[i - money] != 10001) dp[i] = Math.min(dp[i], dp[i - money] + 1);
            }
        }

        return (dp[total] == 10001) ? -1 : dp[total];
    }
}
