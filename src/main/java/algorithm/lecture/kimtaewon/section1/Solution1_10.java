package algorithm.lecture.kimtaewon.section1;

import java.util.*;

public class Solution1_10 {

    public int[] solution(String str, char alpha) {
        int[] answer = new int[str.length()];

        int l = 1000;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) != alpha) answer[i] = ++l;
            if (str.charAt(i) == alpha) answer[i] = (l = 0);
        }

        l = 1000;
        for (int i=str.length() - 1; i>=0; i--) {
            if (str.charAt(i) != alpha) answer[i] = Math.min(answer[i], ++l);
            if (str.charAt(i) == alpha) l = 0;
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char alpha = sc.next().charAt(0);
        sc.close();

        Solution1_10 T = new Solution1_10();
        for (int i : T.solution(str, alpha)) {
            System.out.print(i + " ");
        }
    }
}