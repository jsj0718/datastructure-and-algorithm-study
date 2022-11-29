package lecture.kimtaewon.section6;

import java.util.Arrays;
import java.util.Scanner;

public class Solution6_07 {
    public int[][] solution(int[][] coordinate) {
        return Arrays.stream(coordinate)
                .sorted((n1, n2) -> {
                    if (n1[0] == n2[0]) return n1[1] - n2[1];
                    return n1[0] - n2[0];
                })
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] coordinate = new int[n][2];
        for (int i = 0; i < n; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            coordinate[i][0] = num1;
            coordinate[i][1] = num2;
        }

        Solution6_07 solution6_07 = new Solution6_07();
        int[][] answer = solution6_07.solution(coordinate);
        for (int[] num : answer) {
            System.out.println(num[0] + " " + num[1]);
        }
    }
}
