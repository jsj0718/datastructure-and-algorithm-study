package problemsolving.boj.array;

import java.util.Arrays;
import java.util.Scanner;

public class 개수세기_10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).mapToInt(Integer::intValue).toArray();
        int v = Integer.parseInt(sc.nextLine());

        //when
        long result = Arrays.stream(arr).filter(i -> i == v).count();

        //then
        System.out.println(result);
    }
}
