package lecture.engineerkorea.stack;

import java.util.EmptyStackException;

public class Stack<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();

        T removeData = top.data;
        top = top.next;
        return removeData;
    }

    public void push(T item) {
        Node<T> node = new Node<>(item);
        node.next = top;
        top = node;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
