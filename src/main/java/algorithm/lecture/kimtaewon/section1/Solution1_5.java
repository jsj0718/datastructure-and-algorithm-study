package algorithm.lecture.kimtaewon.section1;

import java.util.*;

public class Solution1_5 {

    public String solution(String str) {
        String answer = "";

        char[] cArr = str.toCharArray();
        int lt = 0, rt = str.length() - 1;

        while (lt < rt) {
            if (isAlpha(cArr[lt]) && isAlpha(cArr[rt])) {
                char tmp = cArr[lt];
                cArr[lt] = cArr[rt];
                cArr[rt] = tmp;
            }
            lt++;
            rt--;
        }

        answer = String.valueOf(cArr);
        return answer;
    }

    private boolean isAlpha(char c) {
        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
            return true;
        }
        return false;
    }

    public String solutionV2(String str) {
        String answer = "";

        char[] cArr = str.toCharArray();
        int lt = 0, rt = str.length() - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(cArr[lt])) lt++;
            else if (!Character.isAlphabetic(cArr[rt])) rt--;
            else {
                char tmp = cArr[lt];
                cArr[lt] = cArr[rt];
                cArr[rt] = tmp;
                lt++;
                rt--;
            }
        }

        answer = String.valueOf(cArr);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        Solution1_5 T = new Solution1_5();
        System.out.println(T.solution(str));
    }
}