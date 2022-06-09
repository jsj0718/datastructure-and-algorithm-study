package algorithm.lecture.kimtaewon.section2;

import java.util.*;

public class Solution2_10 {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, -1, 0, 1};
    
    public int solution(int n, int[][] arr) {
        int answer = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int cnt = 0;
                for (int k=0; k<4; k++) {
                    int y = i + dy[k];
                    int x = j + dx[k];
                    
                    if (x < 0 || y < 0 || x >= n || y >= n) {
                        cnt++;
                    } else if (arr[i][j] > arr[y][x]) {
                        cnt++;
                    }
                }
                if (cnt == 4) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public int solutionV2(int n, int[][] arr) {
        int answer = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                boolean flag = true;
                for (int k=0; k<4; k++) {
                    int y = i + dy[k];
                    int x = j + dx[k];
                    if (x >= 0 && y >= 0 && x < n && y < n && arr[i][j] > arr[x][y]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }

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

        Solution2_10 T = new Solution2_10();
        System.out.println(T.solutionV2(n, arr));
    }
}
