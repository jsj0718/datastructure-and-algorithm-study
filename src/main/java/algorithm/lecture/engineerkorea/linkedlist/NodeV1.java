package algorithm.lecture.engineerkorea.linkedlist;

public class NodeV1 {
    int data;
    NodeV1 next;

    NodeV1(int data) {
        this.data = data;
    }

    void append(int data) {
        NodeV1 end = new NodeV1(data);
        NodeV1 n = this;

        while(n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    void delete(int data) {
        NodeV1 n = this;
        while(n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retreive() {
        NodeV1 n = this;
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }
    
}
