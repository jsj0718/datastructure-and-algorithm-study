package problemsolving.boj.template;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        //logic
        int result = 0;
        for (int i = 1; i < n; i++) {
            int sum = i + Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
            if (sum == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
