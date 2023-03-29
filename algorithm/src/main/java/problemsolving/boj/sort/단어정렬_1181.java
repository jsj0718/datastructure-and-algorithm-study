package problemsolving.boj.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 단어정렬_1181 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 단어정렬_1181().solution();
    }

    private void solution() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = new StringTokenizer(br.readLine()).nextToken();
        }

        //logic
        Arrays.stream(words).collect(Collectors.toSet())
                .stream().sorted((s1, s2) -> (s1.length() == s2.length()) ? s1.compareTo(s2) : s1.length() - s2.length())
                .forEach(System.out::println);
    }
}
