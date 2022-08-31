package lecture.engineerkorea.stackandqueue;

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

    public static void sort(Stack<Integer> s1) {
        Stack<Integer> s2 = new Stack<>();

        while(!s1.isEmpty()) {
            Integer data = s1.pop();
            while(!s2.isEmpty() && s2.peek() > data) {
                s1.push(s2.pop());
            }
            s2.push(data);
        }

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}
