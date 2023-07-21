package problemsolving.boj.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class 평균_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        int n = Integer.parseInt(sc.nextLine());
        double[] arr = Arrays.stream(sc.nextLine().split(" ")).map(Double::valueOf).mapToDouble(Double::doubleValue).toArray();

        //when
        double max = Arrays.stream(arr).max().getAsDouble();
        IntStream.range(0, n).forEach(i -> arr[i] = arr[i] / max * 100);

        //then
        System.out.println(Arrays.stream(arr).average().getAsDouble());
    }
}
