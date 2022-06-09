package algorithm.lecture.kimtaewon.section4;

import java.util.*;

public class Solution4_04 {
    
    public int solution(String str1, String str2) {
        int answer = 0;

        Map<Character, Integer> currMap = new HashMap<>();
        Map<Character, Integer> originMap = new HashMap<>();
        
        for (int i=0; i<str2.length(); i++) {
            char currCharacter = str1.charAt(i);
            int currCount = currMap.containsKey(currCharacter) ? currMap.get(currCharacter) : 0;
            currMap.put(currCharacter, currCount + 1);

            char originCharacter = str2.charAt(i);
            int originCount = originMap.containsKey(originCharacter) ? originMap.get(originCharacter) : 0;
            originMap.put(originCharacter, originCount + 1);
        }

        if(isEqualMaps(currMap, originMap)) answer++;

        for (int i=str2.length(); i<str1.length(); i++) {
            char removeCharacter = str1.charAt(i-str2.length());
            int removeCount = currMap.containsKey(removeCharacter) ? currMap.get(removeCharacter) : 0;
            currMap.put(removeCharacter, removeCount - 1);
            
            if (currMap.get(removeCharacter) == 0) currMap.remove(removeCharacter);

            char addCharacter = str1.charAt(i);
            int addCount = currMap.containsKey(addCharacter) ? currMap.get(addCharacter) : 0;
            currMap.put(addCharacter, addCount + 1);

            if (isEqualMaps(currMap, originMap)) answer++;
        }

        return answer;
    }

    private boolean isEqualMaps(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() != map2.size()) return false;

        Iterator<Character> keys = map1.keySet().iterator();
        while(keys.hasNext()) {
            Character key = keys.next();
            if (map1.get(key) != map2.get(key)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        sc.close();

        Solution4_04 T = new Solution4_04();
        System.out.println(T.solution(str1, str2));
    }
}
