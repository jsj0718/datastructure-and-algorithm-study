package problemsolving.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블랙잭_2798 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 블랙잭_2798().solution();
    }

    private void solution() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        //logic
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (max < sum && sum <= m) max = sum;
                }
            }
        }

        System.out.println(max);
    }
}