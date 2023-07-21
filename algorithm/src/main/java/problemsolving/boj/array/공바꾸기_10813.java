package problemsolving.boj.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 공바꾸기_10813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        String[] nums = sc.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        int[] arr = new int[n];
        IntStream.range(0, n).forEach(i -> arr[i] = i + 1);

        //when
        IntStream.range(0, m).forEach(tc -> {
            String[] ij = sc.nextLine().split(" ");
            int i = Integer.parseInt(ij[0]) - 1;
            int j = Integer.parseInt(ij[1]) - 1;

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        });

        //then
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
