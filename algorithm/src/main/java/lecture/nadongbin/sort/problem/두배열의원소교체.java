package lecture.nadongbin.sort.problem;

import java.util.Arrays;

public class 두배열의원소교체 {
    public int solution(int n, int k, int[] arrA, int[] arrB) {
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for (int i = 0; i < k; i++) {
            if (arrA[i] >= arrB[n-i-1]) break;
            swap(arrA, arrB, i);
        }
        return Arrays.stream(arrA).sum();
    }

    private void swap(int[] arrA, int[] arrB, int i) {
        int n = arrA.length ;
        int tmp = arrA[i];
        arrA[i] = arrB[n-i-1];
        arrB[n-i-1] = tmp;
    }
}
