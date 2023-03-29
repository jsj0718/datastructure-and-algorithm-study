package problemsolving.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 설탕배달_2839 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 설탕배달_2839().solution();
    }

    private void solution() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        //logic
        int result = 0;

        while (n != 0) {
            if (n < 3) {
                result = -1;
                break;
            }

            if (n % 5 == 0) {
                result += n / 5;
                break;
            }

            n -= 3;
            result++;
        }

        System.out.println(result);
    }
}
