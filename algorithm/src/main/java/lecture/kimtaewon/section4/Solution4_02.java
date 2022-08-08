package lecture.kimtaewon.section4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Solution4_02 {
    
    public String solution(String str1, String str2) {
        String answer = "NO";

        if (str1.length() != str2.length()) return answer;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for (int i=0; i<str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            int count1 = map1.containsKey(c1) ? map1.get(c1) : 0;
            int count2 = map2.containsKey(c2) ? map2.get(c2) : 0;

            map1.put(c1, count1 + 1);
            map2.put(c2, count2 + 1);
        }

        Iterator<Character> keys = map1.keySet().iterator();
        while (keys.hasNext()) {
            Character key = keys.next();
            if (map1.get(key) != map2.get(key)) return answer;
        }

        answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        sc.close();

        Solution4_02 T = new Solution4_02();
        System.out.println(T.solution(str1, str2));
    }
}
