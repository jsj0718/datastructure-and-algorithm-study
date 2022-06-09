package algorithm.lecture.kimtaewon.section6;

import java.util.*;

public class Solution6_05 {

    public char solution(int n, int[] arr) {
        char answer = 'D';

        Arrays.sort(arr);

        for (int i=0; i<n-1; i++) {
            if (arr[i] == arr[i+1]) {
                return answer;
            }
        }
        
        answer = 'U';
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Solution6_05 T = new Solution6_05();
        System.out.println(T.solution(n, arr));
    }
}
