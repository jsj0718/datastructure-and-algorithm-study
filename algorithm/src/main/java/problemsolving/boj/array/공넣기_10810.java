package problemsolving.boj.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 공넣기_10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        String[] nums = sc.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        int[] arr = new int[n];

        //when
        IntStream.range(0, m).forEach(tc -> {
            String[] ijk = sc.nextLine().split(" ");
            int i = Integer.parseInt(ijk[0]);
            int j = Integer.parseInt(ijk[1]);
            int k = Integer.parseInt(ijk[2]);
            IntStream.rangeClosed(i, j).forEach(idx -> arr[idx - 1] = k);
        });

        //then
        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
