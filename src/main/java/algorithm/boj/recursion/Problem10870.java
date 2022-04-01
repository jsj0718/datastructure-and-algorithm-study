package algorithm.boj.recursion;

public class Problem10870 {
    public static void main(String[] args) {
        System.out.println(fibo(10));
    }

    public static int fibo(int number) {
        if (number < 2) {
            return number;
        }

        return fibo(number - 1) + fibo(number - 2);
    }
}
