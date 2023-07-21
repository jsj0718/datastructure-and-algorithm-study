package problemsolving.boj.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class X보다작은수_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        String[] nums = sc.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int x = Integer.parseInt(nums[1]);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).mapToInt(Integer::intValue).toArray();

        //when
        String result = Arrays.stream(arr).filter(i -> i < x).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
