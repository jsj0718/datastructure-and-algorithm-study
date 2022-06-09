package algorithm.lecture.kimtaewon.section5;

import java.util.*;

public class Solution5_08 {

    public int solution(int n, int m, int[] arr) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<n; i++) {
            queue.add(arr[i]);
        }

        Arrays.sort(arr);

        int candidate = m;
        int order = 0;
        while(!queue.isEmpty()) {
            int person = queue.poll();
            int maxIdx = n-order-1;
            if (person == arr[maxIdx] && candidate == 0) {
                order++;
                break;
            } else if (person == arr[maxIdx] && candidate != 0) {
                order++;
                candidate--;
            } else if (person != arr[maxIdx] && candidate == 0) {
                queue.add(person);
                candidate = queue.size()-1;
            }  else if (person != arr[maxIdx] && candidate != 0) {
                queue.add(person);
                candidate--;
            }
        }

        answer = order;
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

        Solution5_08 T = new Solution5_08();
        System.out.println(T.solution(n, m, arr));
    }
}
