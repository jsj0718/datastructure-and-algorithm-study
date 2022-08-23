package lecture.engineerkorea.linkedlist;

public class LinkedList {
    static class NodeV2 {
        int data;
        NodeV2 next;
    }

    NodeV2 header;

    public LinkedList() {
        this.header = new NodeV2();
    }

    void append(int data) {
        NodeV2 end = new NodeV2();
        end.data = data;
        NodeV2 n = header;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data) {
        NodeV2 n = header;

        while(n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        NodeV2 n = header.next;
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    void removeDuplicate() {
        NodeV2 n = header;

        //n에 null이 할당된 경우 NPE를 방지하기 위해 조건 추가
        while (n != null && n.next != null) {
            NodeV2 runner = n;
            while (runner.next != null) {
                if (runner.next.data == n.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            n = n.next;
        }
    }

}
