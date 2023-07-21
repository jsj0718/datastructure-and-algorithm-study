package problemsolving.boj.array;

import java.util.Scanner;
import java.util.stream.IntStream;

public class 과제제출_5597 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        int[] arr = new int[30];

        //when
        IntStream.range(0, 28).forEach(tc -> arr[Integer.parseInt(sc.nextLine()) - 1] = 1);

        //then
        IntStream.rangeClosed(1, 30).filter(i -> arr[i - 1] == 0).forEach(System.out::println);
    }
}
