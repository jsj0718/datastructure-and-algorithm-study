package problemsolving.boj.array;

import java.util.Arrays;
import java.util.Scanner;

public class 최소최대_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).mapToInt(Integer::intValue).toArray();

        //when
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        //then
        System.out.println(min + " " + max);
    }
}
