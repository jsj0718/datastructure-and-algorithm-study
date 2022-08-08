package lecture.kimtaewon.section3;

import java.util.Scanner;

public class Solution3_03 {
    
    public int solution(int n, int m, int[] arr) {
        int answer = Integer.MIN_VALUE;

        for (int i=0; i<=n-m; i++) {
            int tmp = 0;
            for (int j=i; j<i+m; j++) {
                tmp += arr[j];
            }
            answer = Math.max(answer, tmp);
        }

        return answer;
    }

    public int solutionV2(int n, int m, int[] arr) {
        int answer = Integer.MIN_VALUE;

        int currSum = 0;
        for (int i=0; i<m; i++) {
            currSum += arr[i];
        }
        answer = currSum;

        for (int i=m; i<n; i++) {
            currSum -= arr[i-m];
            currSum += arr[i];
            answer = Math.max(answer, currSum);
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

        Solution3_03 T = new Solution3_03();
        System.out.println(T.solutionV2(n, m, arr));
    }
}
