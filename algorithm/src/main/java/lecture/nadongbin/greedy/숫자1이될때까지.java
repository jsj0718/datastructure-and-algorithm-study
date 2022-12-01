package lecture.nadongbin.greedy;

public class 숫자1이될때까지 {
    public int solution(int n, int k) {
        int answer = 0;

        while (n >= k) {
            answer += (n - (n / k) * k) + 1;
            n /= k;
        }

        answer += (n - 1);

        return answer;
    }
}
