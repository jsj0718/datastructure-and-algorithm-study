package problemsolving.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[] {0, 0};

        List<String> prevWords = new ArrayList<>();

        int count = 0;

        for (String word : words) {
            count++;

            //조건1. 한 글자인 단어는 안된다.
            if (word.length() < 2) {
                break;
            }

            if (!prevWords.isEmpty()) {
                //조건2. 이미 나온 단어가 나와서는 안된다.
                if (prevWords.contains(word)) {
                    break;
                }

                //조건3. 마지막 단어의 마지막 문자를 이어서 말해야 한다.
                String lastWord = prevWords.get(prevWords.size() - 1);
                if (lastWord.charAt(lastWord.length() - 1) != word.charAt(0)) {
                    break;
                }
            }

            prevWords.add(word);
        }

        if (prevWords.size() != words.length) {
            answer[0] = (count % n == 0) ? n : (count % n);
            answer[1] = (count % n == 0) ? (count / n) : (count / n + 1);
        }
        return answer;
    }
}
