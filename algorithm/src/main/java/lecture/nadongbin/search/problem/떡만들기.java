package lecture.nadongbin.search.problem;

import java.util.Arrays;

public class 떡만들기 {
    public int solution(int n, int m, int[] items) {
        Arrays.sort(items);
        int start = 0;
        int end = items[n - 1];

        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int target = sum(items, mid);

            if (target < m) end = mid - 1;
            else {
                start = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }

    private int sum(int[] items, int mid) {
        return Arrays.stream(items)
                .filter(item -> item > mid)
                .map(item -> item - mid)
                .sum();
    }
}
