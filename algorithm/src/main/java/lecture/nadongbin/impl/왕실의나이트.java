package lecture.nadongbin.impl;

public class 왕실의나이트 {
    public int solution(String s) {
        int answer = 0;

        int[][] steps = {{-2, -1}, {-1, -2}, {1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}};

        int x = s.charAt(0) - 'a' + 1;
        int y = s.charAt(1) - '0';

        for (int[] step : steps) {
            int nx = x + step[0];
            int ny = y + step[1];

            if (nx >= 1 && nx <= 8 && ny >= 1  && ny <= 8) answer++;
        }

        return answer;
    }
}
