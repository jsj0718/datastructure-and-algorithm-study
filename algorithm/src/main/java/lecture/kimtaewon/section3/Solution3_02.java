package lecture.kimtaewon.section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution3_02 {
    
    public List<Integer> solution(int n, int[] arr1, int m, int[] arr2) {
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int lt = 0, rt = 0;

        while (lt < n && rt < m) {
            if (arr1[lt] > arr2[rt]) rt++;
            else if (arr1[lt] < arr2[rt]) lt++;
            else {
                answer.add(arr1[lt]);
                lt++;
                rt++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i=0; i<n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i=0; i<m; i++) {
            arr2[i] = sc.nextInt();
        }

        sc.close();

        Solution3_02 T = new Solution3_02();
        for (int i : T.solution(n, arr1, m, arr2)) {
            System.out.print(i + " ");
        }

    }
}
