package lecture.engineerkorea.graph;

import lecture.engineerkorea.graph.Graph;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

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
    void dfs() {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        graph.dfs();

        assertThat(outContent.toString()).contains("0 1 3 5 7 6 8 4 2");
    }

    @Test
    void dfsRecursion() {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        graph.dfsRecursion();

        assertThat(outContent.toString()).contains("0 1 2 4 3 5 6 8 7");
    }

    @Test
    void bfs() {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        graph.bfs();

        assertThat(outContent.toString()).contains("0 1 2 3 4 5 6 7 8");
    }

    /*
      0
     /
     1 ㅡㅡ 3   7
     |  /   \ /
     | /     5
     2 ㅡㅡ 4   \
                6 ㅡ 8
     */
    @Test
    void graphSearch_true() {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        assertTrue(graph.search(1, 8));
    }

    /*
      0
     /
     1 ㅡㅡ 3   7
     |  /     /
     | /     5
     2 ㅡㅡ 4   \
                6 ㅡ 8
     */
    @Test
    void graphSearch_false() {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        assertFalse(graph.search(1, 8));
    }
}