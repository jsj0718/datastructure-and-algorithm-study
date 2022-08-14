package lecture.engineerkorea.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void testQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        assertEquals(queue.remove(), 1);
        assertEquals(queue.remove(), 2);
        assertEquals(queue.peek(), 3);
        assertEquals(queue.remove(), 3);
        assertFalse(queue.isEmpty());
        assertEquals(queue.remove(), 4);
        assertTrue(queue.isEmpty());
    }
}