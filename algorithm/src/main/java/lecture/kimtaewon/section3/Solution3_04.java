package lecture.kimtaewon.section3;

import java.util.Scanner;

public class Solution3_04 {
    
    //오답 (비교 - 합계 - 포인터 이동)
    public int solution(int n, int m, int[] arr) {
        int answer = 0;

        int lt = 0, rt = 0, sum = 0;
        while(lt < n && rt < n) {
            if (sum < m) {
                sum += arr[rt];
                rt++;
            }
            else if (sum > m) {
                sum -= arr[lt];
                lt++;
            }
            else {
                sum += arr[rt];
                rt++;
                answer++;
            }
        }

        return answer;
    }

    //정답 (포인터 이동 - 합계 - 비교)
    public int solutionV2(int n, int m, int[] arr) {
        int answer = 0;

        int lt = 0, sum = 0;
        for (int rt=0; rt<n; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
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

        Solution3_04 T = new Solution3_04();
        System.out.println(T.solutionV2(n, m, arr));
    }
}
