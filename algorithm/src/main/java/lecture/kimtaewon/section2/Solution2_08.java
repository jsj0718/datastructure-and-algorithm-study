package lecture.kimtaewon.section2;

import java.util.Scanner;

public class Solution2_08 {
    
    //Timeout
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        int rank = 1;
        int count = 0;
        for (int i=0; i<n; i++) {
            //최대 점수를 찾는다.
            int max = findMax(n, arr);

            //최대 점수를 가진 인원을 찾은 후 등수를 매긴다.
            while (findIndex(n, arr, max) != -1) {
                int idx = findIndex(n, arr, max);
                answer[idx] = rank;
                arr[idx] = Integer.MIN_VALUE;
                count++;
            }

            rank += count;
            count = 0;
        }

        return answer;
    }

    public int findMax(int n, int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public int findIndex(int n, int[] arr, int max) {
        for (int i=0; i<n; i++) {
            if (arr[i] == max) {
                return i;
            }
        }
        return -1;
    }

    public int[] solutionV2(int n, int[] arr) {
        int[] answer = new int[n];

        for (int i=0; i<n; i++) {
            int score = arr[i];
            int rank = 1;
            for (int j=0; j<n; j++) {
                if (score < arr[j]) rank++;
            }
            answer[i] = rank;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Solution2_08 T = new Solution2_08();
        for (int i : T.solutionV2(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
