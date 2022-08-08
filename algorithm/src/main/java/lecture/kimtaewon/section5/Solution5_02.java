package lecture.kimtaewon.section5;

import java.util.Scanner;
import java.util.Stack;

public class Solution5_02 {
    
    public String solution(String str) {
        String answer = "";

        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') stack.add(c);
            else if (c == ')') stack.pop();
            else {
                if (stack.empty()) answer += c;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        Solution5_02 T = new Solution5_02();
        System.out.println(T.solution(str));
    }
}
