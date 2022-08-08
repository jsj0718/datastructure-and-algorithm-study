package lecture.ohheum.recursion;

import java.util.Scanner;

public class PowerSet {
    //문제 1
    private static char data[] = {'a', 'b', 'c', 'd', 'e', 'f'};
    private static int n = data.length;
    private static boolean[] included = new boolean[n];

    //문제 2
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int M;
    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) {
        //문제1
        powerSetV1(0);

        //문제2
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.close();
        visited = new boolean[N + 1];
        arr = new int[M];
//        powerSetV2(0);
//        powerSetV3(0);
//        powerSetV4(0);
        powerSetV5(0);
        System.out.println(sb);
    }

    public static void powerSetV1(int k) {
        if (k == n) {
            for (int i = 0; i < n; i++) {
                if (included[i]) {
                    System.out.print(data[i]);
                }
            }
            System.out.println();
            return;
        }
        included[k] = false;
        powerSetV1(k + 1);
        included[k] = true;
        powerSetV1(k + 1);

    }

    public static void powerSetV2(int level) {
        if (level == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[level] = i;
                powerSetV2(level + 1);
                visited[i] = false;
            }
        }
    }

    public static void powerSetV3(int level) {
        if (level == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[level] = i;
                powerSetV3(level + 1);
            }
        }
    }

    public static void powerSetV4(int level) {
        if (level == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[level] = i;
            powerSetV4(level + 1);
        }
    }

    public static void powerSetV5(int level) {
        if (level == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (level != 0 && arr[level-1] > i) {
                continue;
            }

            arr[level] = i;
            powerSetV5(level + 1);
        }
    }

}
