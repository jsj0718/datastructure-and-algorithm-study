package lecture.nadongbin.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 계수정렬 {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();

        int[] count = new int[Arrays.stream(arr).max().getAsInt() + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                answer.add(i);
                count[i]--;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
