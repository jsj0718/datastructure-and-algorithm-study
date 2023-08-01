package problemsolving.boj.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소힙_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < n; tc++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) System.out.println((pq.isEmpty()) ? 0 : pq.poll());
            else pq.add(num);
        }
    }
}
