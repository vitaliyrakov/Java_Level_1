import java.util.Random;

public class Dog extends Animal {
    private double runLimit = 500;
    private double swimLimit = 10;
    private double jampLimit = 0.5;

    public Dog() {
        this.runLimit = runLimit * dispersLimitK;
        this.swimLimit = swimLimit * dispersLimitK;
        this.jampLimit = jampLimit * dispersLimitK;
    }

    @Override
    protected void run(int length) {
        System.out.println("результат: run: " + (length <= runLimit ? "true" : "false"));
    }

    @Override
    protected void swim(int lenght) {
        System.out.println("результат: swim: " + (lenght <= swimLimit ? "true" : "false"));
    }

    @Override
    protected void jampOver(double hight) {
        System.out.println("результат: jampOver: " + (hight <= jampLimit ? "true" : "false"));
    }

    public void info() {
        System.out.println("Dog: runLimit: " + runLimit + " swimLimit: " + swimLimit + " jampLimit: " + jampLimit);
    }
}
