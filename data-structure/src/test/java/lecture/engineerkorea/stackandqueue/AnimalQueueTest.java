package lecture.engineerkorea.stackandqueue;

import lecture.engineerkorea.stackandqueue.AnimalQueue.AnimalShelter;
import lecture.engineerkorea.stackandqueue.AnimalQueue.Cat;
import lecture.engineerkorea.stackandqueue.AnimalQueue.Dog;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnimalQueueTest {

    @Test
    void testAnimal() {
        Dog d1 = new Dog("puppy");
        Dog d2 = new Dog("chichi");
        Dog d3 = new Dog("choco");
        Cat c1 = new Cat("shasha");
        Cat c2 = new Cat("miumiu");
        Cat c3 = new Cat("gaga");

        AnimalShelter as = new AnimalShelter();
        as.enqueue(d1);
        as.enqueue(c1);
        as.enqueue(d2);
        as.enqueue(c2);
        as.enqueue(d3);
        as.enqueue(c3);

        assertThat(as.dequeueCat().info()).isEqualTo("2) type: CAT, name: shasha");
        assertThat(as.dequeueDog().info()).isEqualTo("1) type: DOG, name: puppy");
        assertThat(as.dequeue().info()).isEqualTo("3) type: DOG, name: chichi");
        assertThat(as.dequeue().info()).isEqualTo("4) type: CAT, name: miumiu");
        assertThat(as.dequeue().info()).isEqualTo("5) type: DOG, name: choco");
        assertThat(as.dequeue().info()).isEqualTo("6) type: CAT, name: gaga");
    }
}