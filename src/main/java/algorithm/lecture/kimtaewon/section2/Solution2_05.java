package algorithm.lecture.kimtaewon.section2;

import java.util.*;

public class Solution2_05 {

    public int solution(int n) {
        int answer = 0;
        int primeNumberCnt = 0;
        for (int i=2; i<=n; i++) {
            for (int j=2; j<=Math.sqrt(i); j++) {
                if (i % j == 0) {
                    primeNumberCnt++;
                    break;
                }
            }
        }

        answer = n - primeNumberCnt - 1;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Solution2_05 T = new Solution2_05();
        System.out.println(T.solution(n));
    }
}
