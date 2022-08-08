package lecture.ohheum.recursion;

public class Code01 {

    public static void main(String[] args) {
        int n = 4;
        funcV1(n);
        System.out.println(funcV2(n));
        System.out.println(factorial(n));
        System.out.println(power(2, n));
        System.out.println(fibo(n));
        System.out.println(gcdV1(90, 72));
        System.out.println(gcdV2(90, 72));

    }

    public static void funcV1(int n) {
        //Base Case
        if (n <= 0) {
            return;
        } else {
            System.out.println("Hello");
            funcV1(n - 1); //Recursive Case
        }
    }

    public static int funcV2(int n) {
        if (n == 0) {
            return 0;
        }

        return funcV2(n - 1) + n;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x, n - 1);
        }
    }

    public static int fibo(int n) {
        if (n < 2) return n;

        return fibo(n - 1) + fibo(n - 2);
    }

    //최대공약수
    public static int gcdV1(int m, int n) {
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }

        if (m % n == 0) {
            return n;
        }

        return gcdV1(n, m % n);
    }

    public static int gcdV2(int p, int q) {
        if (q == 0) return p;

        return gcdV2(q, p % q);
    }
}
