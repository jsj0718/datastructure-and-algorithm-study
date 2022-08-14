package lecture.engineerkorea.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(stack.pop(), 4);
        assertEquals(stack.pop(), 3);
        assertEquals(stack.peek(), 2);
        assertEquals(stack.pop(), 2);
        assertFalse(stack.isEmpty());
        assertEquals(stack.pop(), 1);
        assertTrue(stack.isEmpty());
    }
}