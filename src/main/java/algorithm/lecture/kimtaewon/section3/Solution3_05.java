package algorithm.lecture.kimtaewon.section3;

import java.util.*;

public class Solution3_05 {
    
    public int solution(int n) {
        int answer = 0;

        int lt = 1, sum = 0;
        for (int rt=1; rt<=n/2+1; rt++) {
            sum += rt;
            if (sum == n) answer++;
            while(sum >= n) {
                sum -= lt;
                lt++;
                if (sum == n) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Solution3_05 T = new Solution3_05();
        System.out.println(T.solution(n));
    }
}
