package lecture.engineerkorea.linkedlist;

public class NodeDemo {
    int data;
    NodeDemo next;

    NodeDemo(int data) {
        this.data = data;
    }

    void append(int data) {
        NodeDemo end = new NodeDemo(data);
        NodeDemo n = this;

        while(n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    void delete(int data) {
        NodeDemo n = this;
        while(n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        NodeDemo n = this;
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }
    
}
