package problemsolving.boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem7662 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                String status = input[0];
                int num = Integer.parseInt(input[1]);

                if (status.equals("I")) {
                    minHeap.offer(num);
                    maxHeap.offer(num);
                } else if (status.equals("D")) {
                    if (!minHeap.isEmpty()) {
                        if (num == 1) {
                            removeNumber(minHeap, maxHeap.poll());
                        } else if (num == -1) {
                            removeNumber(maxHeap, minHeap.poll());
                        }
                    }
                }
            }
            if (minHeap.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(maxHeap.peek()).append(" ").append(minHeap.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void removeNumber(Queue<Integer> queue, int num) {
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()) {
            Integer val = queue.poll();
            if (val == num) {
                break;
            }
            temp.add(val);
        }
        queue.addAll(temp);
    }

}
