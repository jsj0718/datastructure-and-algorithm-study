package lecture.kimtaewon.section2;

import java.util.Scanner;

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

    //에라토스테네스 체 적용
    public int solutionV2(int n) {
        int answer = 0;
        int[] checkArr = new int[n+1];

        for (int i=2; i<=n; i++) {
            if (checkArr[i] == 0) {
                answer++;
                for (int j=i; j<=n; j+=i) {
                    checkArr[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        Solution2_05 T = new Solution2_05();
        System.out.println(T.solutionV2(n));
    }
}
