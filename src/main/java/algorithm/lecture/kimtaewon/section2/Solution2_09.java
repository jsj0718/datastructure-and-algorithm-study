package algorithm.lecture.kimtaewon.section2;

import java.util.*;

public class Solution2_09 {
    
    public int solution(int n, int[][] arr) {
        int answer = 0;

        int sum1, sum2;
        //Row, Col 합계 구하기
        for (int i=0; i<n; i++) {
            sum1 = sum2 = 0;
            for (int j=0; j<n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(Math.max(sum1, sum2), answer);
        }

        sum1 = sum2 = 0;
        //양 대각선 합계 구하기
        for (int i=0; i<n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        answer = Math.max(Math.max(sum1, sum2), answer);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        sc.close();

        Solution2_09 T = new Solution2_09();
        System.out.println(T.solution(n, arr));
    }
}
