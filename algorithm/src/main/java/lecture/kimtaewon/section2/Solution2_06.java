package lecture.kimtaewon.section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public List<Integer> solutionV2(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int i=0; i<n; i++) {
            int tmp = arr[i];
            int reserveNum = 0;
            //숫자 뒤집기
            while (tmp != 0) {
                int rest = tmp % 10;
                reserveNum = reserveNum * 10 + rest;
                tmp /= 10;
            }
            //소수 판단 후 리스트 추가
            if (isPrime(reserveNum)) answer.add(reserveNum);
        }

        return answer;
    }

    public boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n % i == 0) return false;
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
        for (int i : T.solutionV2(n, arr)) System.out.print(i + " ");
    }    
}
