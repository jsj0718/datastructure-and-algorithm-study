package lecture.nadongbin.impl;

import java.util.HashMap;
import java.util.Map;

public class 상하좌우 {
    public static Map<String, int[]> direction = new HashMap<>() {{
        put("R", new int[] {0, 1});
        put("L", new int[] {0, -1});
        put("U", new int[] {-1, 0});
        put("D", new int[] {1, 0});
    }};

    public int[] solution(int n, String plans) {
        int x = 1;
        int y = 1;

        for (String plan : plans.split(" ")) {
            int[] dir = direction.get(plan);
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx > 0 && nx < n + 1 && ny > 0 && ny < n + 1) {
                x = nx;
                y = ny;
            }
        }

        return new int[] {x, y};
    }
}
