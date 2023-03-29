
package problemsolving.boj.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class 좌표압축_18870 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new 좌표압축_18870().solution();
    }

    private void solution() throws Exception {
        //param
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] coordinate = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coordinate[i] = Integer.parseInt(st.nextToken());
        }

        //logic
        List<Integer> sortedCoordinate = Arrays.stream(coordinate).mapToObj(Integer::valueOf).collect(Collectors.toSet())
                .stream().sorted().collect(Collectors.toList());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortedCoordinate.size(); i++) {
            map.put(sortedCoordinate.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for (int element : coordinate) {
            sb.append(map.get(element)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }
}
