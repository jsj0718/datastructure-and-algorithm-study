package lecture.kimtaewon.section3;

import java.util.Scanner;

public class Solution3_01 {
    
    public int[] solution(int n, int[] arr1, int m, int[] arr2) {
        int[] answer = new int[n + m];

        int lt = 0, rt = 0, idx = 0;
        while (lt < n && rt < m) {
            if (arr1[lt] < arr2[rt]) {
                answer[idx] = arr1[lt];
                lt++;
                idx++;
            } else {
                answer[idx] = arr2[rt];
                rt++;
                idx++;
            }
        }

        while (lt < n) {
            answer[idx] = arr1[lt];
            lt++;
            idx++;
        }

        while (rt < m) {
            answer[idx] = arr2[rt];
            rt++;
            idx++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i=0; i<n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i=0; i<m; i++) {
            arr2[i] = sc.nextInt();
        }

        sc.close();

        Solution3_01 T = new Solution3_01();
        for (int i : T.solution(n, arr1, m, arr2)) {
            System.out.print(i + " ");
        }
    }
}
