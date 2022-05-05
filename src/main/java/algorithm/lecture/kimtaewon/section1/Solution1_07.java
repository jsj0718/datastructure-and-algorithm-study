package algorithm.lecture.kimtaewon.section1;

import java.util.*;

public class Solution1_07 {

    public String solution(String str) {
        String answer = "";
        
        char[] cArr = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (Character.toUpperCase(cArr[lt]) != Character.toUpperCase(cArr[rt])) return "NO";
            lt++;
            rt--;
        }

        answer = "YES";
        return answer;
    }

    public String solutionV2(String str) {
        String answer = "YES";
        int len = str.length();
        for (int i=0; i<len/2; i++) {
            if (Character.toUpperCase(str.charAt(i)) != Character.toUpperCase(str.charAt(len - i - 1))) {
                return "NO";
            }
        }

        return answer;
    }

    public String solutionV3(String str) {
        String answer = "NO";

        str = str.toUpperCase();
        String tmp = new StringBuilder(str).reverse().toString();

        if (str.equals(tmp)) {
            return "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        Solution1_07 T = new Solution1_07();
        System.out.println(T.solutionV3(str));
    }
}