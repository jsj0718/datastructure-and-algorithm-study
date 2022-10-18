package programmers.level2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Level2Test {

    @Test
    @DisplayName("최대 2명을 탈 수 있는 보트에서 무게 제한이 있을 때 최소한의 보트를 구하는 문제")
    void 구명보트() {
        //given
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        //when
        Arrays.sort(people);

        int pointer = 0;
        for (int i=people.length-1; i>pointer; i--) {
            if (people[pointer] + people[i] <= limit) pointer++;
        }

        //then
        assertThat(people.length - pointer).isEqualTo(3);
    }
}
