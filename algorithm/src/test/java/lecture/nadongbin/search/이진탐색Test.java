package lecture.nadongbin.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class 이진탐색Test {

    @Test
    void solutionV1() {
        //given
        이진탐색 이진탐색 = new 이진탐색();
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        //when
        int answer = 이진탐색.binarySearchV1(array, 7, 0, array.length - 1);

        //then
        assertThat(answer).isEqualTo(3);
    }

    @Test
    void solutionV2() {
        //given
        이진탐색 이진탐색 = new 이진탐색();
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        //when
        int answer = 이진탐색.binarySearchV2(array, 7, 0, array.length - 1);

        //then
        assertThat(answer).isEqualTo(3);
    }
}