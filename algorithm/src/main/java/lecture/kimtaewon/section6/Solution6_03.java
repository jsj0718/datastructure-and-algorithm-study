package lecture.kimtaewon.section6;

import java.util.Scanner;

//삽입 정렬
public class Solution6_03 {

    public int[] solution(int n, int[] arr) {
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j>0; j--) {
                if (arr[j-1] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                } else {
                    break;
                }
            }
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

        Solution6_03 T = new Solution6_03();
        for (int result : T.solution(n, arr)) {
            System.out.print(result + " ");
        }
    }
}
