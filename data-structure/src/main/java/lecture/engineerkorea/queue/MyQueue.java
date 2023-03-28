package lecture.engineerkorea.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stackNewest, stackOldest;

    MyQueue() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    public T peek() {
        if (size() == 0) throw new NoSuchElementException();

        shiftStacks();

        return stackOldest.peek();
    }

    public T remove() {
        if (size() == 0) throw new NoSuchElementException();

        shiftStacks();

        return stackOldest.pop();
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
}
