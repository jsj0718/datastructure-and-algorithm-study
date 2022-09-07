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
            Node node = stack.pop();
            for (Node neighbor : node.adjacent) {
                if (!neighbor.marked) {
                    neighbor.marked = true;
                    stack.push(neighbor);
                }
            }
            visit(node);
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

    public void dfsRecursion(Node node) {
        if (node == null) return;
        node.marked = true;
        visit(node);
        for (Node neighbor : node.adjacent) {
            if (!neighbor.marked) {
                dfsRecursion(neighbor);
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
            Node node = queue.remove();
            for (Node neighbor : node.adjacent) {
                if (!neighbor.marked) {
                    neighbor.marked = true;
                    queue.add(neighbor);
                }
            }
            visit(node);
        }
    }

    private void visit(Node n) {
        System.out.print(n.data + " ");
    }
}
