package problemsolving.boj.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 커트라인_25305 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 커트라인_25305().solution();
    }

    private void solution() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> scores = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores.add(Integer.parseInt(st.nextToken()));
        }

        //logic
        Integer result = scores.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(k - 1);

        System.out.println(result);
    }
}
