package lecture.engineerkorea.tree;

import lecture.engineerkorea.tree.Tree.Node;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TreeTest {

    @Test
    void inorder() {
        Tree tree = new Tree();

        Node n4 = tree.makeNode(null, 4, null);
        Node n5 = tree.makeNode(null, 5, null);
        Node n2 = tree.makeNode(n4, 2, n5);
        Node n3 = tree.makeNode(null, 3, null);
        Node n1 = tree.makeNode(n2, 1, n3);

        tree.setRoot(n1);
        List<Integer> result = tree.inorder(tree.getRoot());

        assertThat(result.get(0)).isEqualTo(4);
        assertThat(result.get(1)).isEqualTo(2);
        assertThat(result.get(2)).isEqualTo(5);
        assertThat(result.get(3)).isEqualTo(1);
        assertThat(result.get(4)).isEqualTo(3);
    }

    @Test
    void preorder() {
        Tree tree = new Tree();

        Node n4 = tree.makeNode(null, 4, null);
        Node n5 = tree.makeNode(null, 5, null);
        Node n2 = tree.makeNode(n4, 2, n5);
        Node n3 = tree.makeNode(null, 3, null);
        Node n1 = tree.makeNode(n2, 1, n3);

        tree.setRoot(n1);
        List<Integer> result = tree.preorder(tree.getRoot());

        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(2);
        assertThat(result.get(2)).isEqualTo(4);
        assertThat(result.get(3)).isEqualTo(5);
        assertThat(result.get(4)).isEqualTo(3);
    }

    @Test
    void postorder() {
        Tree tree = new Tree();

        Node n4 = tree.makeNode(null, 4, null);
        Node n5 = tree.makeNode(null, 5, null);
        Node n2 = tree.makeNode(n4, 2, n5);
        Node n3 = tree.makeNode(null, 3, null);
        Node n1 = tree.makeNode(n2, 1, n3);

        tree.setRoot(n1);
        List<Integer> result = tree.postorder(tree.getRoot());

        assertThat(result.get(0)).isEqualTo(4);
        assertThat(result.get(1)).isEqualTo(5);
        assertThat(result.get(2)).isEqualTo(2);
        assertThat(result.get(3)).isEqualTo(3);
        assertThat(result.get(4)).isEqualTo(1);
    }

    @Test
    void testArrayToBinarySearchTree() {
        //given
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i;
        }

        Tree tree = new Tree();
        tree.makeTree(a);

        //when & then
        tree.searchBinaryTree(tree.root, 2);
    }

    @Test
    void testBSTtoListRecursive() {
        //given
        Tree tree = new Tree();
        tree.makeTree(10);

        //when
        List<LinkedList<Node>> lists = tree.BSTtoListRecursive();

        //then
        assertThat(lists.get(0).size()).isEqualTo(1);
        assertThat(lists.get(1).size()).isEqualTo(2);
        assertThat(lists.get(2).size()).isEqualTo(4);
        assertThat(lists.get(3).size()).isEqualTo(3);

        tree.printList(lists);
    }

    @Test
    void testBSTtoListBFS() {
        //given
        Tree tree = new Tree();
        tree.makeTree(10);

        //when
        List<LinkedList<Node>> lists = tree.BSTtoListBFS();

        //then
        assertThat(lists.get(0).size()).isEqualTo(1);
        assertThat(lists.get(1).size()).isEqualTo(2);
        assertThat(lists.get(2).size()).isEqualTo(4);
        assertThat(lists.get(3).size()).isEqualTo(3);

        tree.printList(lists);
    }
}