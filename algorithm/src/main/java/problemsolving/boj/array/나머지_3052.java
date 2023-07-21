package problemsolving.boj.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class 나머지_3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        int[] arr = new int[10];
        IntStream.range(0, 10).forEach(i -> arr[i] = Integer.parseInt(sc.nextLine()) % 42);

        //when
        System.out.println(Arrays.stream(arr).distinct().count());
    }
}
