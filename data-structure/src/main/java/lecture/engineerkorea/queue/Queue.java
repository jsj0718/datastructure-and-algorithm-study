package lecture.engineerkorea.queue;

import java.util.NoSuchElementException;

public class Queue<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> node = new Node<>(item);
        if (last != null) last.next = node;
        last = node;
        if (first == null) first = last;
    }

    public T remove() {
        if (first == null) throw new NoSuchElementException();

        T removeItem = first.data;
        first = first.next;
        if (first == null) last = null;
        return removeItem;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();

        return first.data;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }
}
