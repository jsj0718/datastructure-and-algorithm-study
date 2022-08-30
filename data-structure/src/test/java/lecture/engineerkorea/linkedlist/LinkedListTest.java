package lecture.engineerkorea.linkedlist;

import lecture.engineerkorea.linkedlist.LinkedList.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static lecture.engineerkorea.linkedlist.LinkedList.Node.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream printStream = System.out;

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restore() {
        System.setOut(printStream);
    }

    @Test
    void testAppend() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.retrieve();

        assertThat(outContent.toString()).contains("1 -> 2 -> 3 -> 4");
    }

    @Test
    void testDelete() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.delete(1);
        linkedList.delete(4);
        linkedList.retrieve();

        assertThat(outContent.toString()).contains("2 -> 3");
    }

    @Test
    void testDeleteDuplicate() {
        LinkedList linkedList = new LinkedList();
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(1);
        linkedList.removeDuplicate();
        linkedList.retrieve();

        assertThat(outContent.toString()).contains("3 -> 2 -> 4 -> 1");
    }

    @Test
    void testKthToLast() {
        //given
        int k = 2;
        LinkedList linkedList = new LinkedList();

        //when & then

        /* first가 null이면 예외 반환 */
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.kthToLast(linkedList.get(0), k));

        /* total보다 k가 크면 예외 발생 */
        linkedList.append(1);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.kthToLast(linkedList.get(0), k));

        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        /* 올바른 결과 반환 */
        assertThat(linkedList.kthToLast(linkedList.get(0), k).data).isEqualTo(3);
    }

    @Test
    void testKthToLastByRecursionV1_success() {
        //given
        int k = 2;
        LinkedList linkedList = new LinkedList();

        //when & then
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        linkedList.kthToLastByRecursionV1(linkedList.get(0), k);
        assertThat(outContent.toString()).contains(String.valueOf(k), String.valueOf(3));
    }

    @Test
    void testKthToLastByRecursionV1_fail() {
        //given
        int k = 2;
        LinkedList linkedList = new LinkedList();

        //when & then
        linkedList.append(1);
        linkedList.kthToLastByRecursionV1(linkedList.get(0), k);
        assertThat(outContent.toString()).contains("");
    }

    @Test
    void testKthToLastByRecursionV2() {
        //given
        int k = 2;
        LinkedList linkedList = new LinkedList();


        //when
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        LinkedList.Reference reference = new LinkedList.Reference();
        Node foundNode = linkedList.kthToLastByRecursionV2(linkedList.get(0), k, reference);

        //then
        assertThat(foundNode).isEqualTo(linkedList.get(0).next.next);
        assertThat(foundNode.data).isEqualTo(3);
    }

    @Test
    void testKthToLastByPointer() {
        //given
        int k = 3;
        LinkedList linkedList = new LinkedList();

        //when
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        //then
        Node foundNode = linkedList.kthToLastByPointer(linkedList.get(0), k);
        assertThat(foundNode.data).isEqualTo(3);
    }

    @Test
    void testGet() {
        //given
        LinkedList linkedList = new LinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        //when & then
        assertThat(linkedList.get(0).data).isEqualTo(1);
        assertThat(linkedList.get(1).data).isEqualTo(2);
        assertThat(linkedList.get(2).data).isEqualTo(3);
        assertThat(linkedList.get(3).data).isEqualTo(4);
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(4));
    }

    @Test
    void testSize() {
        LinkedList linkedList = new LinkedList();
        assertThat(linkedList.size()).isEqualTo(0);

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        assertThat(linkedList.size()).isEqualTo(4);
    }
    
    @Test
    void testDeleteMedium() {
        LinkedList linkedList = new LinkedList();

        linkedList.append(1);
        assertThat(linkedList.deleteMediumNode(linkedList.get(0))).isFalse(); //노드가 하나인 경우 삭제 불가능
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        assertThat(linkedList.deleteMediumNode(linkedList.get(1))).isTrue();
        assertThat(linkedList.deleteMediumNode(linkedList.get(linkedList.size() - 1))).isFalse(); //마지막 노드인 경우 삭제 불가능

        assertThat(linkedList.size()).isEqualTo(3);
        assertThat(linkedList.get(0).data).isEqualTo(1);
        assertThat(linkedList.get(1).data).isEqualTo(3);
        assertThat(linkedList.get(2).data).isEqualTo(4);
    }

    @Test
    void testPartitionV1() {
        int[] values = {8, 5, 2, 7, 3, 4};
        int[] sortedValues = {2, 3, 4, 8, 5, 7};

        LinkedList linkedList = new LinkedList();

        linkedList.append(8);
        linkedList.append(5);
        linkedList.append(2);
        linkedList.append(7);
        linkedList.append(3);
        linkedList.append(4);

        assertThat(linkedList.size()).isEqualTo(6);
        for (int i = 0; i < linkedList.size(); i++) {
            assertThat(linkedList.get(i).data).isEqualTo(values[i]);
        }

        int index = 0;
        Node partition = linkedList.partitionV1(linkedList.get(0), 5);
        while (partition != null) {
            assertThat(partition.data).isEqualTo(sortedValues[index++]);
            partition = partition.next;
        }
        assertThat(index).isEqualTo(6);
    }

    @Test
    void testPartitionV2() {
        int[] values = {8, 5, 2, 7, 3, 4};
        int[] sortedValues = {4, 3, 2, 8, 5, 7};

        LinkedList linkedList = new LinkedList();

        linkedList.append(8);
        linkedList.append(5);
        linkedList.append(2);
        linkedList.append(7);
        linkedList.append(3);
        linkedList.append(4);

        assertThat(linkedList.size()).isEqualTo(6);
        for (int i = 0; i < linkedList.size(); i++) {
            assertThat(linkedList.get(i).data).isEqualTo(values[i]);
        }

        int index = 0;
        Node partition = linkedList.partitionV2(linkedList.get(0), 5);
        while (partition != null) {
            assertThat(partition.data).isEqualTo(sortedValues[index++]);
            partition = partition.next;
        }
        assertThat(index).isEqualTo(6);
    }

    @Test
    void testGetIntersection_success() {
        Node n1 = new Node(5);
        Node n2 = n1.addNext(7);
        Node n3 = n2.addNext(9);
        Node n4 = n3.addNext(10);
        Node n5 = n4.addNext(7);
        Node n6 = n5.addNext(6);

        Node m1 = new Node(6);
        Node m2 = m1.addNext(8);
        Node m3 = m2.addNext(n4);

        Node intersection = getIntersection(n1, m1);
        assertThat(intersection).isEqualTo(n4);
    }

    @Test
    void testGetIntersection_fail() {
        Node n1 = new Node(5);
        Node n2 = n1.addNext(7);
        Node n3 = n2.addNext(9);
        Node n4 = n3.addNext(10);
        Node n5 = n4.addNext(7);
        Node n6 = n5.addNext(6);

        Node m1 = new Node(6);
        Node m2 = m1.addNext(8);
        Node m3 = m2.addNext(10);

        Node intersection = getIntersection(n1, m1);
        assertThat(intersection).isNull();
    }

    @Test
    void testSumReverse() {
        //테스트 1
        Node n1 = new Node(9);
        Node n2 = n1.addNext(1);
        Node n3 = n2.addNext(4);

        Node m1 = new Node(6);
        Node m2 = m1.addNext(4);
        Node m3 = m2.addNext(3);

        Node result1 = sumListsReverse(n1, m1, 0);
        assertThat(result1.data).isEqualTo(5);
        assertThat(result1.next.data).isEqualTo(6);
        assertThat(result1.next.next.data).isEqualTo(7);
        assertThat(result1.next.next.next).isNull();

        //테스트 2
        Node x1 = new Node(1);

        Node y1 = new Node(9);

        Node result2 = sumListsReverse(x1, y1, 0);
        assertThat(result2.data).isEqualTo(0);
        assertThat(result2.next.data).isEqualTo(1);

        //테스트 3
        Node l1 = new Node(1);

        Node p1 = new Node (9);
        Node p2 = p1.addNext(9);

        Node result3 = sumListsReverse(l1, p1, 0);
        assertThat(result3.data).isEqualTo(0);
        assertThat(result3.next.data).isEqualTo(0);
        assertThat(result3.next.next.data).isEqualTo(1);
    }

    @Test
    void sumList() {
        Node n1 = new Node(9);
        Node n2 = n1.addNext(1);

        Node m1 = new Node(1);
        Node m2 = m1.addNext(1);

        Node result1 = sumLists(n1, m1);
        assertThat(result1.data).isEqualTo(1);
        assertThat(result1.next.data).isEqualTo(0);
        assertThat(result1.next.next.data).isEqualTo(2);
        assertThat(result1.next.next.next).isNull();
    }

    @Test
    void testFindLoop() {
        //루프 존재 시
        Node n1 = new Node(1);
        Node n2 = n1.addNext(2);
        Node n3 = n2.addNext(3);
        Node n4 = n3.addNext(4);
        Node n5 = n4.addNext(5);
        Node n6 = n5.addNext(6);
        Node n7 = n6.addNext(7);
        Node n8 = n7.addNext(8);
        n8.addNext(n3);

        Node loopStartNode1 = findLoop(n1);
        assertThat(loopStartNode1).isEqualTo(n3);

        //루프 존재 안할 시
        Node m1 = new Node(1);
        Node m2 = m1.addNext(2);
        Node m3 = m2.addNext(3);
        Node m4 = m3.addNext(4);
        Node m5 = m4.addNext(5);
        Node m6 = m5.addNext(6);
        Node m7 = m6.addNext(7);
        Node m8 = m7.addNext(8);

        Node loopStartNode2 = findLoop(m1);
        assertThat(loopStartNode2).isNull();
    }
}