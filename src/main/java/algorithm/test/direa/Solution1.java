package algorithm.test.direa;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static Map<Character, Integer> voteMap = new HashMap<>();

    public String solution(String vote) {
        String answer = "";

        countVote(vote);

        Integer maxResult = getMaxResult();

        answer = getVoteResult(vote, maxResult, answer);

        if (answer.equals("BA")) {
            answer = "AB";
        }

        return answer;
    }

    public String getVoteResult(String vote, Integer maxResult, String answer) {
        for (Character key : voteMap.keySet()) {
            if (key == 'C' && voteMap.get(key) >= vote.length() / 2) {
                answer = "C";
                return answer;
            } else if (key != 'C' && voteMap.get(key) == maxResult) {
                answer += key;
            }
        }
        return answer;
    }

    public static void countVote(String vote) {
        for (char c : vote.toCharArray()) {
            int count = voteMap.containsKey(c) ? voteMap.get(c) : 0;
            voteMap.put(c, count + 1);
        }
    }

    public static Integer getMaxResult() {
        Integer a = voteMap.containsKey('A') ? voteMap.get('A') : 0;
        Integer b = voteMap.containsKey('B') ? voteMap.get('B') : 0;

        return Math.max(a, b);
    }
}
