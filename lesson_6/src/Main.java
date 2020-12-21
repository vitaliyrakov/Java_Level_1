public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        dog1.info();
        dog2.info();
        cat1.info();
        cat2.info();

        dog1.run(20);
        dog2.run(2000);
        dog1.jampOver(2);
        dog2.jampOver(0.5);
        dog1.swim(2);
        dog2.swim(500);

        cat1.run(20);
        cat2.run(2000);
        cat1.jampOver(3);
        cat2.jampOver(1);
        cat1.swim(2);
        cat2.swim(500);
    }
}
