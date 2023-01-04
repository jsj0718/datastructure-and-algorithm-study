package lecture.nadongbin.search;

public class 순차탐색 {
    public int sequentialSearch(String[] array, String target) {
        int answer = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}
