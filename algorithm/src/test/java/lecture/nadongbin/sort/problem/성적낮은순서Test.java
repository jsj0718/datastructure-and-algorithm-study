package lecture.nadongbin.sort.problem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class 성적낮은순서Test {

    @Test
    void solution() {
        //given
        HashMap<String, Integer> studentInfos = new HashMap<>() {{
            put("홍길동", 95);
            put("이순신", 77);
            put("정약용", 100);
        }};

        성적낮은순서 성적낮은순서 = new 성적낮은순서();

        //when
        String[] answer = 성적낮은순서.solution(studentInfos);

        //then
        Assertions.assertThat(answer).isEqualTo(new String[]{"이순신", "홍길동", "정약용"});

    }
}