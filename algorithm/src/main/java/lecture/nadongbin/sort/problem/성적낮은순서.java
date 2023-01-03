package lecture.nadongbin.sort.problem;

import java.util.Comparator;
import java.util.Map;

public class 성적낮은순서 {
    public String[] solution(Map<String, Integer> studentInfos) {
        return studentInfos.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}
