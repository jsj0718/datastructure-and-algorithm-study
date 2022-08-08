package lecture.kimtaewon.section6;

import java.util.Scanner;

//선택 정렬
public class Solution6_01 {
    
    public int[] solution(int n, int[] arr) {
        for (int i=0; i<n; i++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int j=i; j<n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        return arr;
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Solution6_01 T = new Solution6_01();
        for (int result : T.solution(n, arr)) {
            System.out.print(result + " ");
        }
    }
}

