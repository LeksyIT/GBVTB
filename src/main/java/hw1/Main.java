package hw1;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new HomeCat("Tom", 0, 200),
                new HomeCat("Tom1", 10, 300),
                new HomeCat("Tom2", 5, 100),
                new Dog("Zaza", 0, 800),
                new Dog("Zaza2", 20, 500),
                new Dog("Zaza3", 10, 300)
        };
        for (Animal animal : animals) {
            animal.run(210);
            animal.swim(4);
            animal.swim(11);
        }
        System.out.println(Animal.counter);
    }
}
