import java.util.Random;

public class Dog extends Animal {
    private double runLimit = 500;
    private double swimLimit = 10;
    private double jampLimit = 0.5;

    Random rand = new Random();

    public Dog() {
        int dispersLimitD = rand.nextInt(dispersLimit*2);
        System.out.println(dispersLimitD);
        System.out.println((1-dispersLimit/100 + dispersLimitD/100));
        this.runLimit = runLimit*(1-dispersLimit/100 + dispersLimitD/100);
        this.swimLimit = swimLimit*(1-dispersLimit/100 + dispersLimitD/100);
        this.jampLimit = jampLimit*(1-dispersLimit/100 + dispersLimitD/100);
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
