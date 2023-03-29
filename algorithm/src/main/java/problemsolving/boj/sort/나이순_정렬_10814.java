package problemsolving.boj.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 나이순_정렬_10814 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 나이순_정렬_10814().solution();
    }

    private void solution() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        String[][] members = new String[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            members[i][0] = st.nextToken();
            members[i][1] = st.nextToken();
        }

        //logic
        Arrays.stream(members).sorted(Comparator.comparingInt(m -> Integer.parseInt(m[0])))
                .forEach(m -> System.out.println(m[0] + " " + m[1]));
    }
}
