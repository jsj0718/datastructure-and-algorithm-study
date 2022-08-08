package lecture.kimtaewon.section6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution6_06 {
    
    public List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for (int i=0; i<n; i++) {
            if (arr[i] != tmp[i]) {
                answer.add(i+1);                
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

        Solution6_06 T = new Solution6_06();
        for (int result : T.solution(n, arr)) {
            System.out.print(result + " ");
        }
    }
}
