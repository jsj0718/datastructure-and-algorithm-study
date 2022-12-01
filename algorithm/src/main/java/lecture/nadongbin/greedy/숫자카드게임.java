package lecture.nadongbin.greedy;

public class 숫자카드게임 {
    public int solution(int n, int m, int[][] cards) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (min > cards[i][j]) min = cards[i][j];
            }
            answer = Math.max(answer, min);
        }

        return answer;
    }
}
