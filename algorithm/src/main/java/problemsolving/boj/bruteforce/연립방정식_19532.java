package problemsolving.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연립방정식_19532 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 연립방정식_19532().solutionV1();
    }

    private void solutionV1() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        //logic
        double[][] inverseProcession = new double[2][2];
        double denominator = (double) 1 / (a * e - b * d);
        inverseProcession[0][0] = denominator * e;
        inverseProcession[0][1] = denominator * -1 * b;
        inverseProcession[1][0] = denominator * -1 * d;
        inverseProcession[1][1] = denominator * a;

        double x = inverseProcession[0][0] * c + inverseProcession[0][1] * f;
        double y = inverseProcession[1][0] * c + inverseProcession[1][1] * f;
        System.out.println(Math.round(x) + " " + Math.round(y));
    }

    private void solutionV2() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        //logic
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if ((a*x + b*y == c) && (d*x + e*y == f)) {
                    System.out.println(x + " " + y);
                    break;
                }
            }
        }
    }

}
