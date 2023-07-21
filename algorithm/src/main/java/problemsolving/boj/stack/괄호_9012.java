package problemsolving.boj.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호_9012 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 괄호_9012().solution();
    }

    private void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();

            boolean flag = true;
            String[] ps = new StringTokenizer(br.readLine()).nextToken().split("");
            for (String ele : ps) {
                if (ele.equals("(")) stack.push(ele);
                else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty() && flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
