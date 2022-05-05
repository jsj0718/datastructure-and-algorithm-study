package algorithm.lecture.kimtaewon.section1;

import java.util.*;

public class Solution1_09 {

    public String solution(String str) {
        String answer = "";
        str = str.replaceAll("[^0-9]", "");
        for (char c : str.toCharArray()) {
            if (answer.equals("") && c == '0') {
                continue;
            }
            answer += c;
        }
        return answer;
    }

    public Integer solutionV2(String str) {
        String answer = "";
        
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) answer += c;
        }

        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        Solution1_09 T = new Solution1_09();
        // System.out.println(T.solution(str));
        System.out.println(T.solutionV2(str));
    }
}