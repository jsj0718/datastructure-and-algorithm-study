package algorithm.lecture.kimtaewon.section1;

import java.util.*;

public class Solution1_1 {
    public int solution(String str, char alpha) {
        int count = 0;
        str = str.toUpperCase();
        alpha = Character.toUpperCase(alpha);
        for (char c : str.toCharArray()) {
            if (c == alpha) {
                count++;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        Solution1_1 T = new Solution1_1();
        
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char alpha = sc.next().charAt(0);
        sc.close();

        System.out.println(T.solution(str, alpha));
    }
}