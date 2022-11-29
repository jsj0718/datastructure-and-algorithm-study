package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 최대값_최소값 {
    public String solution(String s) {
        int[] numbers = Arrays.stream(s.split(" ")).mapToInt(number -> Integer.valueOf(number)).toArray();
        return Arrays.stream(numbers).min().getAsInt() + " " + Arrays.stream(numbers).max().getAsInt();
    }

    public String solutionV2(String s) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());

        String[] numbers = s.split(" ");
        for (String number : numbers) {
            maxHeap.add(Integer.valueOf(number));
            minHeap.add(Integer.valueOf(number));
        }

        return maxHeap.peek() + " " + minHeap.peek();
    }
}
