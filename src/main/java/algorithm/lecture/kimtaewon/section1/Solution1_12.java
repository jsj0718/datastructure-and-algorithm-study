package algorithm.lecture.kimtaewon.section1;

import java.util.*;

public class Solution1_12 {
    
    public String solution(int n, String str) {
        String answer = "";

        String tmp = "";
        int l = 0;

        for (char c : str.toCharArray()) {
            tmp += c;
            l++;
            if (l == 7) {
                answer += decode(tmp);
                tmp = "";
                l = 0;
            }
        }

        return answer;
    }

    private char decode(String str) {
        String result = "";

        for (char c : str.toCharArray()) {
            if (c == '#') result += '1';
            else if (c == '*') result += '0';
        }
        
        return (char) Integer.parseInt(result, 2);
    }

    public String solutionV2(int n, String str) {
        String answer = "";

        for (int i=0; i<n; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            str = str.substring(7);
            answer += (char) Integer.parseInt(tmp, 2);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        sc.close();

        Solution1_12 T = new Solution1_12();
        // System.out.println(T.solution(n, str));        
        System.out.println(T.solutionV2(n, str));
    }
}