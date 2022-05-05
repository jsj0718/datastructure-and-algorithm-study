package algorithm.lecture.kimtaewon.section1;

import java.util.*;

public class Solution1_03 {
    public String solution(String s) {
        String answer = "";

        String[] strList = s.split(" ");
        for (String str : strList) {
            if (isLongerThanFront(answer, str)) {
                answer = str;
            }
        }

        return answer;
    }

    public boolean isLongerThanFront(String frontStr, String backStr) {
        if (frontStr.length() >= backStr.length()) {
            return false;
        }
        return true;
    }

    public String solutionV2(String s) {
        String answer = "";
        
        int maxVal = Integer.MIN_VALUE;
        int len, pos;
        while ((pos = s.indexOf(" ")) != -1) {
            String tmp = s.substring(0, pos);
            len = tmp.length();
            if (len > maxVal) {
                maxVal = len;
                answer = tmp;
            }

            s = s.substring(pos + 1);
        }

        if (s.length() > maxVal) answer = s;

        return answer;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        
        Solution1_03 T = new Solution1_03();
//        System.out.println(T.solution(s));
        System.out.println(T.solutionV2(s));
    }
}