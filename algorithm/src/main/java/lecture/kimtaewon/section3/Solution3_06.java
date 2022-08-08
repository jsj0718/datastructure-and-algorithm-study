package lecture.kimtaewon.section3;

import java.util.Scanner;

public class Solution3_06 {
    
    public int solution(int n, int m, int[] arr) {
        int answer = 0;

        int lt = 0, cnt = m, sum = 0;
        for (int rt=0; rt<n; rt++) {
            while(cnt < 1 && arr[rt] == 0) {
                if (arr[lt++] == 0) cnt++;
                sum--;
            }
            if (arr[rt] == 0) cnt--;
            sum++;

            answer = Math.max(answer, sum);            
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        Solution3_06 T = new Solution3_06();
        System.out.println(T.solution(n, m, arr));
    }
}
