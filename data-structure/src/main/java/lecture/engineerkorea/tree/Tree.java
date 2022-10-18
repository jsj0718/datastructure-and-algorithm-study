package lecture.engineerkorea.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    List<Integer> result;

    public Tree() {
        this.result = new ArrayList<>();
    }

    public void setRoot(Node node) {
        this.root = node;
    }

    public Node getRoot() {
        return root;
    }

    public Node makeNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    /**
     * left -> root -> right
     */
    public List<Integer> inorder(Node node) {
        if(node != null) {
            inorder(node.left);
            result.add(node.data);
            inorder(node.right);
        }
        return result;
    }

    /**
     * root -> left -> right
     */
    public List<Integer> preorder(Node node) {
        if(node != null) {
            result.add(node.data);
            preorder(node.left);
            preorder(node.right);
        }
        return result;
    }

    /**
     * left -> right -> root
     */
    public List<Integer> postorder(Node node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            result.add(node.data);
        }
        return result;
    }

    /**
     * 정렬된 배열을 이진검색트리로 만드는 메소드
     */
    public void makeTree(int[] a) {
        root = makeTreeRecursive(a, 0, a.length - 1);
    }

    public void makeTree(int size) {
        root = makeTreeRecursive(0, size - 1);
    }

    public Node makeTreeRecursive(int[] a, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(a[mid]);
        node.left = makeTreeRecursive(a, start, mid - 1);
        node.right = makeTreeRecursive(a, mid + 1, end);
        return node;
    }

    public Node makeTreeRecursive(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeTreeRecursive(start, mid - 1);
        node.right = makeTreeRecursive(mid + 1, end);
        return node;
    }

    /**
     * 이진검색트리를 활용한 검색 메소드
     */
    public void searchBinaryTree(Node n, int find) {
        if (find < n.data) {
            System.out.println("Data is smaller than " + n.data);
            searchBinaryTree(n.left, find);
        } else if (find > n.data) {
            System.out.println("Data is bigger than " + n.data);
            searchBinaryTree(n.right, find);
        } else {
            System.out.println("Data found!");
        }
    }

    /**
     * 이진 트리 노드들을 각 레벨별로 LinkedList에 담는 메소드
     */
    public List<LinkedList<Node>> BSTtoListRecursive() {
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        BSTtoListRecursive(root, lists, 0);
        return lists;
    }

    public void BSTtoListRecursive(Node root, List<LinkedList<Node>> lists, int level) {
        if (root == null) return;

        LinkedList<Node> list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);
        BSTtoListRecursive(root.left, lists, level + 1);
        BSTtoListRecursive(root.right, lists, level + 1);
    }

    public List<LinkedList<Node>> BSTtoListBFS() {
        List<LinkedList<Node>> result = new ArrayList<>();
        LinkedList<Node> current = new LinkedList<>();
        if (root != null) current.add(root);
        while (current.size() > 0) {
            result.add(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<>();
            for (Node parent : parents) {
                if (parent.left != null) current.add(parent.left);
                if (parent.right != null) current.add(parent.right);
            }
        }
        return result;
    }

    public void printList(List<LinkedList<Node>> lists) {
        for (LinkedList<Node> list : lists) {
            for (Node node : list) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }
}
