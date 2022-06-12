package algorithm.lecture.kimtaewon.section4;

import java.util.*;

public class Solution4_05 {
    
    public int solution(int n, int m, int[] arr) {
        int answer = -1;

        TreeSet<Integer> tree = new TreeSet<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j) continue;
                for (int k=0; k<n; k++) {
                    if (i == k || j == k) continue;
                    tree.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        if (tree.size() < m) return answer;

        int count = m;
        while(count != 1) {
            tree.pollLast();
            count--;
        }
        answer = tree.pollLast();
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

        Solution4_05 T = new Solution4_05();
        System.out.println(T.solution(n, m, arr));
    }
}
