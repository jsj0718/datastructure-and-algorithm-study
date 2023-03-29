package problemsolving.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영화감독_1436 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 영화감독_1436().solution();
    }

    private void solution() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        //logic
        int series = 665;
        while (n != 0) {
            if (String.valueOf(++series).contains("666")) n--;
        }

        System.out.println(series);
    }
}
