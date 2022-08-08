package lecture.kimtaewon.section5;

import java.util.Scanner;
import java.util.Stack;

public class Solution5_05 {

    public int solution(String str) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        int firstCount = 0;
        boolean isLaser = true;

        for(char c : str.toCharArray()) {
            if (c == '(') {
                stack.add(c);
                firstCount++;
                isLaser = true;
            } else {
                stack.pop();
                if (isLaser) {
                    answer += (--firstCount + stack.size());
                    firstCount = 0;
                }
                isLaser = false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        Solution5_05 T = new Solution5_05();
        System.out.println(T.solution(str));
    }
}
