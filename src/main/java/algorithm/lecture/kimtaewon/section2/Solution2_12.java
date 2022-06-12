package algorithm.lecture.kimtaewon.section2;

import java.util.*;

public class Solution2_12 {
    
    public int solution(int n, int m, int[][] arr) {
        int answer = 0;

        for (int i=1; i<=n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j=0; j<m; j++) {
                for (int k=0; k<n; k++) {
                    set.add(arr[j][k]);
                    if (arr[j][k] == i) {
                        break;
                    }
                }
            }
            answer += (n - set.size());
        }
        
        return answer;
    }

    public int solutionV2(int n, int m, int[][] arr) {
        int answer = 0;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                int cnt = 0;
                for (int k=0; k<m; k++) {
                    int mentor = 0;
                    int mentee = 0;
                    for (int s=0; s<n; s++) {
                        if (arr[k][s] == i) mentor = s;
                        if (arr[k][s] == j) mentee = s;
                    }
                    if (mentor < mentee) cnt++; 
                }
                if (cnt == m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();

        Solution2_12 T = new Solution2_12();
        System.out.println(T.solutionV2(n, m, arr));
    }
}
