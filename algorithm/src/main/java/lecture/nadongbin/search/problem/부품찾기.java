package lecture.nadongbin.search.problem;

import java.util.Arrays;
import java.util.HashSet;

public class 부품찾기 {
    public String[] solutionV1(int n, int[] items, int m, int[] targets) {
        String[] answer = new String[m];

        Arrays.sort(items);
        for (int i = 0; i < m; i++) {
            answer[i] = (binarySearch(items, targets[i], 0, items.length - 1)) ? "yes" : "no";
        }

        return answer;
    }

    public boolean binarySearch(int[] items, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (items[mid] == target) return true;
            else if (items[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }

    public String[] solutionV2(int n, int[] items, int m, int[] targets) {
        String[] answer = new String[m];

        int[] itemNo = new int[1000001];
        for (int i = 0; i < n; i++) {
            itemNo[items[i]] = 1;
        }

        for (int i = 0; i < m; i++) {
            answer[i] = (itemNo[targets[i]] == 1) ? "yes" : "no";
        }

        return answer;
    }

    public String[] solutionV3(int n, int[] items, int m, int[] targets) {
        String[] answer = new String[m];

        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(items).forEach(item -> set.add(item));

        for (int i = 0; i < m; i++) {
            answer[i] = (set.contains(targets[i])) ? "yes" : "no";
        }

        return answer;
    }

}
