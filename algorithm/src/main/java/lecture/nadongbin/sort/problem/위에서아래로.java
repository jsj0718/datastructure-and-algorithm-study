package lecture.nadongbin.sort.problem;

import java.util.Arrays;
import java.util.Comparator;

public class 위에서아래로 {
    public int[] solution(int[] arr) {
        Arrays.stream(arr)
                .mapToObj(Integer::valueOf)
                .sorted(Comparator.reverseOrder());
        return arr;
    }
}
