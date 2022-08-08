package lecture.kimtaewon.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1_04 {

    public List<String> solution(int N, String[] arr) {
        List<String> answer = new ArrayList<>();

        for (String s : arr) {
            answer.add(reverse(s));
        }

        return answer;
    }

    private String reverse(String s) {
        String reverseStr = "";

        for (int i=s.length() - 1; i>=0; i--) {
            reverseStr += s.charAt(i);
        }

        return reverseStr;
    }

    public List<String> solutionV2(int N, String[] arr) {
        List<String> answer = new ArrayList<>();

        for (String s : arr) {
            String tmp = new StringBuilder(s).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    public List<String> solutionV3(int N, String[] arr) {
        List<String> answer = new ArrayList<>();

        for (String s : arr) {
            char[] charArr = s.toCharArray();
            int lt = 0, rt = s.length() - 1;

            while (lt < rt) {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;

                lt++;
                rt--;
            }

            answer.add(new String(charArr));
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.next();
        }
        sc.close();
        
        Solution1_04 T = new Solution1_04();
//        for (String s : T.solution(N, arr)) {
        for (String s : T.solutionV2(N, arr)) {
//        for (String s : T.solutionV3(N, arr)) {

            System.out.println(s);
        }
    }
}