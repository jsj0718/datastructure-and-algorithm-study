package lecture.kimtaewon.section1;

import java.util.Scanner;

public class Solution1_11 {

    public String solution(String str) {
        String answer = "";

        int repeat = 0;
        char alpha = '0';

        for (char c : str.toCharArray()) {
            if (c != alpha) {
                if (repeat > 1) {
                    answer += repeat;
                }
                repeat = 1;
                alpha = c;
                answer += alpha;
            } else {
                repeat++;
            }
        }

        if (repeat > 1) answer += repeat;
        
        return answer;
    }

    public String solutionV2(String str) {
        String answer = "";

        str = str + " ";
        
        int cnt = 0;
        char alpha = str.charAt(0);

        for (char c : str.toCharArray()) {
            if (c == alpha) cnt++;
            else {
                answer += alpha;
                alpha = c;
                if (cnt > 1) answer += cnt;
                cnt = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        
        Solution1_11 T = new Solution1_11();
        // System.out.println(T.solution(str));
        System.out.println(T.solutionV2(str));
    }
}