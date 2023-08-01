package problemsolving.boj.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //given
        int n = Integer.parseInt(sc.nextLine());
        int[] orders = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).mapToInt(Integer::intValue).toArray();
        int[] sortedOrders = Arrays.stream(orders).sorted().toArray();

        //when
        int result = 0;
        int pointer = 0;
        for (int sortedOrder : sortedOrders) {
            pointer += sortedOrder;
            result += pointer;
        }

        //then
        System.out.println(result);
    }
}