package lecture.kimtaewon.section4;

import java.util.*;

public class Solution4_03 {
    
    public List<Integer> solution(int n, int m, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<m; i++) {
            int count = map.containsKey(arr[i]) ? map.get(arr[i]) : 0;
            map.put(arr[i], count + 1);
            set.add(arr[i]);
        }

        answer.add(set.size());

        for (int i=m; i<n; i++) {
            int removeCount = map.get(arr[i-m]);
            map.put(arr[i-m], removeCount - 1);
            int addCount = map.containsKey(arr[i]) ? map.get(arr[i]) : 0;
            map.put(arr[i], addCount + 1);
            
            if (map.get(arr[i-m]) == 0) set.remove(arr[i-m]);
            set.add(arr[i]);

            answer.add(set.size());
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Solution4_03 T = new Solution4_03();
        for (int i : T.solution(n, m, arr)) {
            System.out.print(i + " ");
        }
    }
}
