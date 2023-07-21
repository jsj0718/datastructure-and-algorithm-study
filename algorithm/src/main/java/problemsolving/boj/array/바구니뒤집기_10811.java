package problemsolving.boj.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 바구니뒤집기_10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] arr = new int[n];
        IntStream.range(0, n).forEach(i -> arr[i] = i + 1);

        //when
        IntStream.range(0, m).forEach(tc -> {
            String[] ij = sc.nextLine().split(" ");
            int i = Integer.parseInt(ij[0]) - 1;
            int j = Integer.parseInt(ij[1]) - 1;

            IntStream.rangeClosed(i, (i + j) / 2).forEach(idx -> {
                int tmp = arr[idx];
                arr[idx] = arr[i + j - idx];
                arr[i + j - idx] = tmp;
            });

        });

        //then
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
