package lecture.ohheum.recursion;

import java.util.Scanner;

public class Code02 {
    public static void main(String[] args) {
        System.out.println(length("java lecture"));

        printChars("java lecture");
        System.out.println();

        printCharsReverse("java lecture");
        System.out.println();

        printInBinary(4);
        System.out.println();

        int[] data = {1, 2, 3, 4, 5};
        System.out.println(sum(data.length, data));

        int[] dataInt = new int[5];
        readFrom(dataInt.length, dataInt, new Scanner(System.in));
        for (int i : dataInt) {
            System.out.println("i = " + i);
        }
    }

    public static int length(String str) {
        if (str.equals("")) {
            return 0;
        }

        return 1 + length(str.substring(1));
    }

    public static void printChars(String str) {
        if (str.equals("")) {
            return;
        }

        System.out.print(str.charAt(0));
        printChars(str.substring(1));
    }

    public static void printCharsReverse(String str) {
        if (str.equals("")) {
            return;
        }

        printCharsReverse(str.substring(1));
        System.out.print(str.charAt(0));
    }

    public static void printInBinary(int n) {
        if (n < 2) {
            System.out.print(n);
            return;
        }

        printInBinary(n / 2);
        System.out.print(n % 2);
    }

    public static int sum(int n, int[] data) {
        if (n <= 0) {
            return 0;
        }

        return sum(n - 1, data) + data[n - 1];
    }

    public static void readFrom(int n, int[] data, Scanner in) {
        if (n == 0) {
            return;
        }
        readFrom(n - 1, data, in);
        data[n - 1] = in.nextInt();
    }
}
