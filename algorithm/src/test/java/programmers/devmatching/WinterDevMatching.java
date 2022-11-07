package programmers.devmatching;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinterDevMatching {

    @Test
    void 문제1_문자열_축약하기() {
        //given
        String line = "aabbcc";

        //when
        Queue<String> q = new LinkedList<>(Arrays.stream(line.split("")).collect(Collectors.toList()));

        StringBuilder sb = new StringBuilder();
        String currStr = "";
        while (!q.isEmpty()) {
            currStr = q.poll();
            sb.append(currStr);

            boolean flag = false;
            while (!q.isEmpty() && q.peek().equals(currStr)) {
                flag = true;
                q.poll();
            }
            if (flag) sb.append("*");
        }

        System.out.println("sb = " + sb);
    }


    @Test
    void 문제2_학업성적으로_우등반과_열등반으로_나누기() {
        //given
/*
        int n = 6;
        int[] student = {6, 1, 4, 2, 5, 1, 3, 3, 1, 6, 5};
        int[] point = {3, 2, 5, 3, 4, 2, 4, 2, 3, 2, 2};
*/
        int n = 10;
        int[] student = {3, 2, 10, 2, 8, 3, 9, 6, 1, 2};
        int[] point = {3, 2, 2, 5, 4, 1, 2, 1, 3, 3};

        //when
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.rangeClosed(1, n).forEach(i -> map.put(i, 0));

        PriorityQueue<Map.Entry<Integer, Integer>> superiorQueue = new PriorityQueue<>(
                (a, b) -> a.getValue() != b.getValue() ? a.getValue() - b.getValue() : b.getKey() - a.getKey()
        );

        PriorityQueue<Map.Entry<Integer, Integer>> inferiorQueue = new PriorityQueue<>(
                (a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey()
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() <= n / 2) superiorQueue.offer(entry);
            else inferiorQueue.offer(entry);
        }

        String[] answer = new String[student.length];
        for (int i = 0; i < student.length; i++) {
            map.put(student[i], map.get(student[i]) + point[i]);


            if (superiorQueue.peek().getValue() < inferiorQueue.peek().getValue()) {
                answer[i] = "O";
                inferiorQueue.offer(superiorQueue.poll());
                superiorQueue.offer(inferiorQueue.poll());
            } else if (superiorQueue.peek().getValue() == inferiorQueue.peek().getValue()
                    && superiorQueue.peek().getKey() > inferiorQueue.peek().getKey()) {
                answer[i] = "O";
                inferiorQueue.offer(superiorQueue.poll());
                superiorQueue.offer(inferiorQueue.poll());
            } else {
                answer[i] = "X";
            }

            System.out.println("[" + i + "번째] super: " + superiorQueue + ", infer: " + inferiorQueue);
        }

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
    }

}
