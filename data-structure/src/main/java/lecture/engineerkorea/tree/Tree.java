package lecture.engineerkorea.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    static class Node {
        int data;
        Node left;
        Node right;
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
}
