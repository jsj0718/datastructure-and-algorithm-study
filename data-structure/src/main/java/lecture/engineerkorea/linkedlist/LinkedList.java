package lecture.engineerkorea.linkedlist;

public class LinkedList {
    static class Node {
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public Node addNext(int data) {
            Node next = new Node(data);
            this.next = next;
            return next;
        }

        public Node addNext(Node next) {
            this.next = next;
            return next;
        }

        public Node get(int index) {
            Node n = this;
            for (int i = 0; i < index; i++) {
                if (n == null) throw new IndexOutOfBoundsException();
                n = n.next;
            }
            return n;
        }

        public static int size(Node node) {
            int size = 0;
            Node n = node;
            while (n != null) {
                n = n.next;
                size++;
            }
            return size;
        }

        public static Node getIntersection(Node n1, Node n2) {
            int len1 = size(n1);
            int len2 = size(n2);

            if (len1 > len2) {
                n1 = n1.get(len1 - len2);
            } else if (len2 > len1) {
                n2 = n2.get(len2 - len1);
            }

            while (n1 != null && n2 != null) {
                if (n1 == n2) {
                    return n1;
                }
                n1 = n1.next;
                n2 = n2.next;
            }
            return null;
        }
    }

    Node header;

    public LinkedList() {
        this.header = new Node();
    }

    public int size() {
        int size = 0;
        Node n = header;
        while (n.next != null) {
            n = n.next;
            size++;
        }
        return size;
    }

    public Node get(int i) {
        if (i >= size()) throw new IndexOutOfBoundsException();

        int index = 0;
        Node n = header.next;
        while (n != null && n.next != null) {
            if (i == index++) break;
            n = n.next;
        }
        return n;
    }

    public void append(int data) {
        Node end = new Node();
        end.data = data;
        Node n = header;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int data) {
        Node n = header;

        while(n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void retrieve() {
        Node n = header.next;
        while(n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    public void removeDuplicate() {
        Node n = header;

        //n에 null이 할당된 경우 NPE를 방지하기 위해 조건 추가
        while (n != null && n.next != null) {
            Node runner = n;
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

    public Node kthToLast(Node first, int k) {
        if (first == null) return null;

        Node n = first;
        int total = 1;
        while (n.next != null) {
            n = n.next;
            total++;
        }

        if (total < k) throw new IndexOutOfBoundsException();

        n = first;
        for (int i = 1; i < total - k + 1; i++) {
            n = n.next;
        }

        return n;
    }

    public int kthToLastByRecursionV1(Node n, int k) {
        if (n == null) {
            return 0;
        }
        int count = kthToLastByRecursionV1(n.next, k) + 1;
        if (count == k) System.out.println(k + "th to last node is " + n.data);
        return count;
    }

    public Node kthToLastByRecursionV2(Node n, int k, Reference r) {
        if (n == null) {
            return null;
        }
        Node foundNode = kthToLastByRecursionV2(n.next, k, r);
        r.count++;
        if (r.count == k) return n;
        return foundNode;
    }

    public static class Reference {
        public int count = 0;
    }

    public Node kthToLastByPointer(Node first, int k) {
        Node p1 = first;
        Node p2 = first;

        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    //중간 노드 삭제
    public boolean deleteMediumNode(Node n) {
        if (n == null || n.next == null) return false;
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }

    public Node partitionV1(Node n, int x) {
        Node s1 = null;
        Node e1 = null;
        Node s2 = null;
        Node e2 = null;

        while (n != null) {
            //원래 n은 마지막 노드이므로 null을 가져야 한다.
            //따라서 n.next를 백업 후 추후에 next하는 방식으로 진행한다.
            Node next = n.next;
            n.next = null;
            if (n.data < x) {
                if (s1 == null) {
                    s1 = n;
                    e1 = s1;
                }
                else {
                     e1.next = n;
                     e1 = n;
                }
            } else {
                if (s2 == null) {
                    s2 = n;
                    e2 = s2;
                } else {
                    e2.next = n;
                    e2 = n;
                }
            }
            n = next;
        }
        if (s1 == null) {
            return s2;
        }
        e1.next = s2;
        return s1;
    }

    public Node partitionV2(Node n, int x) {
        Node head = n;
        Node tail = n;

        while (n != null) {
            Node next = n.next;
            if (n.data < x) {
                n.next = head;
                head = n;
            } else {
                tail.next = n;
                tail = n;
            }
            n = next;
        }
        tail.next = null; //마지막이므로 next 값이 null
        return head;
    }
}
