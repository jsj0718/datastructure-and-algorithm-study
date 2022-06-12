package algorithm.lecture.kimtaewon.section6;

import java.util.*;

public class Solution6_04 {
    
    public int[] solution(int s, int n, int[] arr) {
        int[] answer = new int[s];

        for (int i=0; i<n; i++) {
            int target = arr[i];
            int idx = s-1;
            
            for (int j=0; j<s; j++) {
                if (target == answer[j]) {
                    idx = j;
                    break;
                }
            }

            int changeValue = answer[0];
            for (int k=0; k<idx; k++) {
                int tmp = answer[k+1];
                answer[k+1] = changeValue;
                changeValue = tmp;
            }
            answer[0] = target;
        }

        return answer;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Solution6_04 T = new Solution6_04();
        for (int result : T.solution(s, n, arr)) {
            System.out.print(result + " ");
        }
    }
}
