package problemsolving.boj.greedy;

import java.util.Scanner;
import java.util.stream.IntStream;

public class 동전0_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        String[] nk = sc.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] moneys = new int[n];
        IntStream.range(0, n).forEach(i -> moneys[i] = Integer.parseInt(sc.nextLine()));

        //when
        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            result += (k / moneys[i]);
            k %= moneys[i];
        }

        //then
        System.out.println(result);
    }
}
