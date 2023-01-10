package lecture.nadongbin.dp;

import java.util.Arrays;

public class 개미전사 {
    public int solution(int[] array) {
        int[] dp = new int[100];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
