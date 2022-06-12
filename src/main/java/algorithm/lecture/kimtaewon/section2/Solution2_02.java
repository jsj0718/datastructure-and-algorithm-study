package algorithm.lecture.kimtaewon.section2;

import java.util.*;

public class Solution2_02 {
    
    public int solution(int n, int[] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            if (max < i) {
                answer++;
                max = i;
            }
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

        Solution2_02 T = new Solution2_02();
        System.out.print(T.solution(n, arr));
    }
}
