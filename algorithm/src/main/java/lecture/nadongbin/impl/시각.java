package lecture.nadongbin.impl;

public class 시각 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    String s = "" + i + j + k;
                    if (s.contains("3")) answer++;
                }
            }
        }

        return answer;
    }
}
