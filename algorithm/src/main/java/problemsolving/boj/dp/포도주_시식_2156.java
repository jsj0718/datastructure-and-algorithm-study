package problemsolving.boj.dp;

import java.util.Arrays;
import java.util.Scanner;

public class 포도주_시식_2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wines = new int[n+1];
        wines[0] = 0;
        for (int i = 1; i <= n; i++) {
            wines[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(solution(wines));
    }

    public static int solution(int[] wines) {
        int[] dp = new int[10002];
        dp[0] = wines[0];
        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];
        for (int i = 3; i < wines.length; i++) {
            dp[i] = Math.max(dp[i-3] + wines[i-1] + wines[i], dp[i-2] + wines[i]);
            dp[i] = Math.max(dp[i-1], dp[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
