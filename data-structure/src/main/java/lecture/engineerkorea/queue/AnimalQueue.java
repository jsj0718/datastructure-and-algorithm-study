package lecture.engineerkorea.queue;

import java.util.LinkedList;

public class AnimalQueue {

    enum AnimalType {
        DOG, CAT
    }

    static abstract class Animal {
        AnimalType type;
        String name;
        int order;

        public Animal(AnimalType type, String name) {
            this.type = type;
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String info() {
            return order + ") type: " + type + ", name: " + name;
        }
    }

    static class Dog extends Animal {
        public Dog(String name) {
            super(AnimalType.DOG, name);
        }
    }

    static class Cat extends Animal {
        public Cat(String name) {
            super(AnimalType.CAT, name);
        }
    }

    static class AnimalShelter {
        LinkedList<Dog> dogs = new LinkedList<>();
        LinkedList<Cat> cats = new LinkedList<>();
        int order;

        public AnimalShelter() {
            this.order = 1;
        }

        void enqueue(Animal animal) {
            animal.setOrder(order++);
            if (animal.type == AnimalType.DOG) {
                dogs.addLast((Dog) animal);
            } else if (animal.type == AnimalType.CAT) {
                cats.addLast((Cat) animal);
            }
        }

        Animal dequeueDog() {
            return dogs.poll();
        }

        Animal dequeueCat() {
            return cats.poll();
        }

        Animal dequeue() {
            if (dogs.isEmpty() && cats.isEmpty()) return null;
            if (dogs.isEmpty()) return cats.poll();
            if (cats.isEmpty()) return dogs.poll();

            if (dogs.peek().getOrder() < cats.peek().getOrder()) {
                return dogs.poll();
            } else {
                return cats.poll();
            }
        }
    }
}
