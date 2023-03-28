package lecture.engineerkorea.queue;

import lecture.engineerkorea.queue.MyQueue;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    @Test
    void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        assertThat(queue.remove()).isEqualTo(1);
        assertThat(queue.remove()).isEqualTo(2);
        assertThat(queue.remove()).isEqualTo(3);
        assertThrows(NoSuchElementException.class, () -> queue.remove());
    }
}