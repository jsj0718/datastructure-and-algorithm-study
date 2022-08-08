package lecture.kimtaewon.section5;

import java.util.Scanner;
import java.util.Stack;

public class Solution5_01 {
    
    public String solution(String str) {
        String answer = "NO";

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.empty()) return answer;
                stack.pop();
            }
        }

        if (stack.empty()) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        Solution5_01 T = new Solution5_01();
        System.out.println(T.solution(str));
    }
}
