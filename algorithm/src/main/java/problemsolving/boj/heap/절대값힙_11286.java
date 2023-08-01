package problemsolving.boj.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절대값힙_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            return Math.abs(o1) - Math.abs(o2);
        });

        int n = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < n; tc++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) System.out.println((pq.isEmpty()) ? 0 : pq.poll());
            else pq.add(num);
        }
    }
}
