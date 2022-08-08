package lecture.kimtaewon.section5;

import java.util.Scanner;
import java.util.Stack;

public class Solution5_03 {
    
    public int solution(int n, int[][] arr, int m, int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int o : order) {
            for (int i=0; i<n; i++) {
                int target = arr[i][o-1];
                arr[i][o-1] = 0;

                if (target == 0) continue;
                
                if (stack.empty()) {
                    stack.add(target);
                    break;
                } else {
                    if (stack.peek() == target) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.add(target);
                    }
                    break;
                }
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

        int m = sc.nextInt();
        int[] order = new int[m];
        for (int i=0; i<m; i++) {
            order[i] = sc.nextInt();
        }

        sc.close();

        Solution5_03 T = new Solution5_03();
        System.out.println(T.solution(n, arr, m, order));
    }
}
