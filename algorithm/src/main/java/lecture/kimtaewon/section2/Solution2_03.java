package lecture.kimtaewon.section2;

import java.util.Scanner;

public class Solution2_03 {
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i=0; i<n; i++) {
            answer[i] = rockPaperScissors(arr1[i], arr2[i]);
        }
        
        return answer;
    }

    public String rockPaperScissors(int n1, int n2) {
        if (n1 == n2) return "D";
        else if (n1 - n2 == 1 || n1 - n2 == -2) return "A";
        else return "B";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();    
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
    
        for (int i=0; i<n; i++) {
            arr1[i] = sc.nextInt();
        }

        for (int i=0; i<n; i++) {
            arr2[i] = sc.nextInt();
        }

        sc.close();

        Solution2_03 T = new Solution2_03();
        for (String s : T.solution(n, arr1, arr2)) {
            System.out.println(s);
        }
    }
}
