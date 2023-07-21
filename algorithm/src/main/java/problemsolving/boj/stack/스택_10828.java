package problemsolving.boj.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_10828 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 스택_10828().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (order.equals("pop")) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.pop());
            } else if (order.equals("size")) {
                System.out.println(stack.size());
            } else if (order.equals("empty")) {
                System.out.println((stack.isEmpty()) ? 1 : 0);
            } else if (order.equals("top")) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());
            }
        }
    }
}
