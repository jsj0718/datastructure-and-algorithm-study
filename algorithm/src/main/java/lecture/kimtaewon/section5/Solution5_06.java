package lecture.kimtaewon.section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution5_06 {
    
    public int solution(int n, int k) {
        int answer = -1;

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            queue.add(i);
        }

        int order = 1;
        while (queue.size() != 1) {
            int tmp = queue.poll();
            if (order != k) {
                queue.add(tmp);
                order++;
            } else {
                order = 1;
            }
        }
        
        answer = queue.poll();
        return answer;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        Solution5_06 T = new Solution5_06();
        System.out.println(T.solution(n, k));
    }
}
