package lecture.kimtaewon.section5;

import java.util.Scanner;
import java.util.Stack;

public class Solution5_04 {

    private final char[] operator = {'+', '-', '*', '/'};

    private boolean isOperator(char c) {
        for (char o : operator) {
            if (c == o) {
                return true;
            }
        }
        return false;
    }

    public int solution(String str) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (!isOperator(c)) {
                stack.add(c - '0');
            } else {
                int right = stack.pop();
                int left = stack.pop();
                switch (c) {
                    case '+': answer = left + right; break;
                    case '-': answer = left - right; break;
                    case '*': answer = left * right; break;
                    case '/': answer = left / right; break;
                }
                stack.add(answer);
            }
        }

        answer = stack.pop();
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        Solution5_04 T = new Solution5_04();
        System.out.println(T.solution(str));
    }
}
