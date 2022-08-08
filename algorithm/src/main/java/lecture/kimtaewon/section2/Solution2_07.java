package lecture.kimtaewon.section2;

import java.util.Scanner;

public class Solution2_07 {

    public int solution(int n, int[] arr) {
        int answer = 0;
        int count = 0;

        for (int i=0; i<n; i++) {
            if (arr[i] == 0) count = 0;
            else if (arr[i] == 1) {
                count++;
                answer += count;
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

        Solution2_07 T = new Solution2_07();
        System.out.println(T.solution(n, arr));
    }
}
