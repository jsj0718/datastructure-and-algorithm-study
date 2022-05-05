package algorithm.lecture.kimtaewon.section2;

import java.util.*;

public class Solution2_06 {

    public List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int i=0; i<n; i++) {
            int reverseNumber = reverseNumber(arr[i]);
            if (isPrimeNumber(reverseNumber) && reverseNumber != 1) {
                answer.add(reverseNumber);
            }
        }

        return answer;
    }

    public int reverseNumber(int i) {
        StringBuilder sb = new StringBuilder();
        return Integer.parseInt(sb.append(String.valueOf(i)).reverse().toString());
    }

    public boolean isPrimeNumber(int n) {
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        Solution2_06 T = new Solution2_06();
        for (int i : T.solution(n, arr)) System.out.println(i + " ");
    }    
}
