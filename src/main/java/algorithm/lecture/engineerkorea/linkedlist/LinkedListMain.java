package algorithm.lecture.engineerkorea.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        NodeV1 n = new NodeV1(3);
        n.append(5);
        n.append(7);
        n.append(9);
        n.delete(7);
        n.retreive();
    }
}