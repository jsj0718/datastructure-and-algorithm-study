package lecture.engineerkorea.tree;

import lecture.engineerkorea.stackandqueue.Queue;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    static class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        public Node(int data) {
            this.data = data;
            this.marked = false;
            this.adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;

    public Graph(int size) {
        this.nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    public void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) n1.adjacent.add(n2);
        if (!n2.adjacent.contains(n1)) n2.adjacent.add(n1);
    }

    public void dfs() {
        dfs(0);
    }

    public void dfs(int index) {
        Stack<Node> stack = new Stack<>();
        Node root = nodes[index];
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()) {
            Node target = stack.pop();
            for (Node n : target.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(target);
        }
    }

    public void dfsRecursion() {
        Node node = nodes[0];
        dfsRecursion(node);
    }

    public void dfsRecursion(int index) {
        Node node = nodes[index];
        dfsRecursion(node);
    }

    public void dfsRecursion(Node root) {
        if (root == null) return;
        root.marked = true;
        visit(root);
        for (Node n : root.adjacent) {
            if (!n.marked) {
                dfsRecursion(n);
            }
        }
    }

    public void bfs() {
        bfs(0);
    }

    public void bfs(int index) {
        Queue<Node> queue = new Queue<>();
        Node root = nodes[index];
        queue.add(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            Node target = queue.remove();
            for (Node n : target.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(target);
        }
    }

    private void visit(Node n) {
        System.out.print(n.data + " ");
    }

    /**
     * 두 지점이 서로 찾아갈 수 있는 경로가 존재하는지 확인하는 메소드
     */
    public boolean search(int i1, int i2) {
        return search(nodes[i1], nodes[i2]);
    }

    public boolean search(Node start, Node end) {
        initMarks();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(start);
        start.marked = true;

        while(!queue.isEmpty()) {
            Node root = queue.removeFirst();
            if (root == end) {
                return true;
            }
            for (Node n : root.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }

    private void initMarks() {
        for (Node node : nodes) {
            node.marked = false;
        }
    }
}
