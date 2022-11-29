package lecture.nadongbin.greedy;

public class 거스름돈 {
    public static int[] change = {500, 100, 50, 10};

    public int solution(int money) {
        int answer = 0;

        for (int i = 0; i < change.length; i++) {
            if (money == 0) break;
            answer += (money / change[i]);
            money %= change[i];
        }

        return answer;
    }
}
