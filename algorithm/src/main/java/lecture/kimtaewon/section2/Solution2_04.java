package lecture.kimtaewon.section2;

import java.util.Scanner;

public class Solution2_04 {
    
    public int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;

        for (int i=2; i<n; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Solution2_04 T = new Solution2_04();

        for (int i : T.solution(n)) {
            System.out.print(i + " ");
        }
    }
}
