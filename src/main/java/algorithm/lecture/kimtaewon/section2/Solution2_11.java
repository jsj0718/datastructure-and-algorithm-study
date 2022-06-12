package algorithm.lecture.kimtaewon.section2;

import java.util.*;

public class Solution2_11 {
    
    public int solution(int n, int[][] arr) {
        int answer = 0;

        int[] result = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j=0; j<5; j++) {
                int ban = arr[i][j];
                for (int k=0; k<n; k++) {
                    if (ban == arr[k][j]) set.add(k);
                }
            }
            result[i] = set.size();
            max = Math.max(max, set.size());
        }
        
        for (int i=0; i<n; i++) {
            if (max == result[i]) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }

    public int solutionV2(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i=1; i<=n; i++) {
            int cnt = 0;
            for (int j=1; j<=n; j++) {
                for (int k=1; k<=5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (max < cnt) {
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n+1][5+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        sc.close();

        Solution2_11 T = new Solution2_11();
        System.out.println(T.solutionV2(n, arr));
    }
}
