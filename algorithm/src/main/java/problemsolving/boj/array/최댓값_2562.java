package problemsolving.boj.array;

import java.util.Scanner;
import java.util.stream.IntStream;

public class 최댓값_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        int[] arr = new int[9];
        IntStream.range(0, 9).forEach(i -> arr[i] = Integer.parseInt(sc.nextLine()));

        //when
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                idx = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(idx);
    }
}
