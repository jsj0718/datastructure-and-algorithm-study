package algorithm.lecture.kimtaewon.section2;

import java.util.*;

public class Solution2_01 {
    
    public List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        answer.add(arr[0]);
        for(int i=1; i<n; i++) {
            if (arr[i] > arr[i-1]) answer.add(arr[i]);
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
        Solution2_01 T = new Solution2_01();
        for (int result : T.solution(n, arr)) {
            System.out.print(result + " ");
        }
    }
}
