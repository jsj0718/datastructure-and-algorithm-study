package lecture.engineerkorea.linkedlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

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
}