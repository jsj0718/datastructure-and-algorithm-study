package problemsolving.boj.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 제로_10773 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 제로_10773().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if (n == 0) stack.pop();
            else stack.push(n);
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}
