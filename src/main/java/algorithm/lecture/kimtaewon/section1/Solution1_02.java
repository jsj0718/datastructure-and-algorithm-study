package algorithm.lecture.kimtaewon.section1;

import java.util.*;

public class Solution1_02 {
/*
    //아스키 코드 이용
    public String solution(String str) {
        char[] strArr = str.toCharArray();

        for (int i=0; i<strArr.length; i++) {
            if (isUpperCase(strArr[i])) {
                strArr[i] = (char) (strArr[i] + 32);
            } else {
                strArr[i] = (char) (strArr[i] - 32);
            }
        }
        return new String(strArr);
    }

    public boolean isUpperCase(char c) {
        if (c >= 65 && c <= 90) {
            return true;
        }
        return false;
    }
*/

    //Character 이용
    public String solution(String str) {
        String answer = "";
        
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) answer += Character.toUpperCase(c);
            else answer += Character.toLowerCase(c);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution1_02 T = new Solution1_02();
        
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        System.out.println(T.solution(str));
    }
}