package lecture.engineerkorea.stackandqueue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void testStackSort() {
        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(5);
        s1.push(1);
        s1.push(6);

        Stack.sort(s1);

        assertThat(s1.pop()).isEqualTo(1);
        assertThat(s1.pop()).isEqualTo(3);
        assertThat(s1.pop()).isEqualTo(5);
        assertThat(s1.pop()).isEqualTo(6);
    }
}