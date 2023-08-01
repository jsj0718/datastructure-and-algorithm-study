package problemsolving.boj.greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class 회의실배정_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        int n = Integer.parseInt(sc.nextLine());

        int[][] records = new int[n][2];
        IntStream.range(0, n).forEach(i -> {
            String[] startAndEnd = sc.nextLine().split(" ");
            records[i][0] = Integer.parseInt(startAndEnd[0]);
            records[i][1] = Integer.parseInt(startAndEnd[1]);
        });

        int[][] sortedRecords = Arrays.stream(records).sorted(((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        })).toArray(int[][]::new);

        //when
        int result = 0;
        int[] pointer = new int[2];
        for (int[] sortedRecord : sortedRecords) {
            if (result == 0 || pointer[1] <= sortedRecord[0]) {
                pointer = sortedRecord;
                result++;
            } else if (pointer[1] > sortedRecord[0] && pointer[1] > sortedRecord[1]) {
                pointer = sortedRecord;
            }
        }

        //then
        System.out.println(result);
    }
}
