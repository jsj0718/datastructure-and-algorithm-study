package lecture.engineerkorea.linkedlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class NodeV1Test {

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
        NodeV1 n = new NodeV1(1);
        n.append(2);
        n.append(3);
        n.append(4);
        n.retrieve();

        assertThat(outContent.toString()).contains("1 -> 2 -> 3 -> 4");
    }

    @Test
    void testDelete() {
        NodeV1 n = new NodeV1(3);
        n.append(5);
        n.append(7);
        n.append(9);
        n.delete(3); //첫 번째 노드를 지울 수 없다. (Header 도입으로 해결)
        n.delete(7);
        n.retrieve();

        assertThat(outContent.toString()).contains("3 -> 5 -> 9");
    }
}