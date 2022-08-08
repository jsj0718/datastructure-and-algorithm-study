package lecture.kimtaewon.section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution5_07 {
    
    public String solution(String requiredSubjects, String appliedSubjects) {
        String answer = "YES";

        Queue<Character> rsq = new LinkedList<>();
        for (char c : requiredSubjects.toCharArray()) {
            rsq.add(c);
        }

        Queue<Character> asq = new LinkedList<>();
        for (char c : appliedSubjects.toCharArray()) {
            asq.add(c);
        }

        while(!asq.isEmpty()) {
            char as = asq.poll();
            if (rsq.isEmpty()) return answer;
            char rs = rsq.peek();
            if (as == rs) rsq.poll();
        }

        if (!rsq.isEmpty()) answer = "NO";
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String requiredSubjects = sc.nextLine();
        String appliedSubjects = sc.nextLine();
        sc.close();

        Solution5_07 T = new Solution5_07();
        System.out.println(T.solution(requiredSubjects, appliedSubjects));
    }
}
