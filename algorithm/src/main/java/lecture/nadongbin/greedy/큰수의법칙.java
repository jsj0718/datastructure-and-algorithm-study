package lecture.nadongbin.greedy;

import java.util.Arrays;

public class 큰수의법칙 {

    public int solution(int n, int m, int k, int[] data) {
        Arrays.sort(data);

        int first = data[n - 1];
        int second = data[n - 2];

        return (m / (k + 1) * (first * k + second)) + (m % (k + 1) * first);
    }
}
