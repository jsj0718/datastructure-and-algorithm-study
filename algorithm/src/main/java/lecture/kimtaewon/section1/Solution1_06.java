package lecture.kimtaewon.section1;

import java.util.Scanner;

public class Solution1_06 {
    
    public String solution(String str) {
        String answer = "";

        char[] cArr = str.toCharArray();
        for (char c : cArr) {
            if (!answer.contains(String.valueOf(c))) {
                answer += c;
            }
        }

        return answer;
    }

    public String solutionV2(String str) {
        String answer = "";

        for (int i=0; i<str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) {
                answer += str.charAt(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        
        Solution1_06 T = new Solution1_06();
//        System.out.println(T.solution(str));
        System.out.println(T.solutionV2(str));
    }
}