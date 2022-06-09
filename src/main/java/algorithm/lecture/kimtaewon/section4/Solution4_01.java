package algorithm.lecture.kimtaewon.section4;

import java.util.*;

public class Solution4_01 {
    
    public String solution(int n, String str) {
        String answer;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            int count = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, count + 1);
        }

        answer = map.entrySet().stream()
            .max((e1, e2) -> e1.getValue() > e2.getValue() ? 1 : -1)
            .get().getKey().toString();

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        sc.close();

        Solution4_01 T = new Solution4_01();
        System.out.println(T.solution(n, str));
    }
}
