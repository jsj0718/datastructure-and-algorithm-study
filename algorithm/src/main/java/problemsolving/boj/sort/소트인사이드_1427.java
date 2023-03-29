package problemsolving.boj.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 소트인사이드_1427 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 소트인사이드_1427().solution();
    }

    private void solution() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> nums = Arrays.stream(st.nextToken().split("")).map(Integer::parseInt).collect(Collectors.toList());

        //logic
        String result = nums.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining());
        System.out.println(result);
    }
}
