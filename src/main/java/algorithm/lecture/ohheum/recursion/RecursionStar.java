package algorithm.lecture.ohheum.recursion;

import java.util.Scanner;

public class RecursionStar {
    public static StringBuilder sb = new StringBuilder();
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                printStar(N, i, j);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void printStar(int n, int x, int y) {
        if (x % 3 == 1 && y % 3 == 1) {
            sb.append(" ");
            return;
        } else if (n == 3) {
            sb.append("*");
            return;
        }

        printStar(n/3, x/3, y/3);
    }
}
