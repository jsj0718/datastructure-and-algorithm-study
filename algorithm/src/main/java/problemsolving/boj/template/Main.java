package problemsolving.boj.template;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            sb.append("+").append("\n");
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() >= nums[idx]) {
                sb.append("-").append("\n");
                if (stack.pop() == nums[idx]) {
                    idx++;
                }
            }
        }

        if (idx == nums.length) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
