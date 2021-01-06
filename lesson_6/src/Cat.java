public class Cat extends Animal {
    private int runLimit = 200;
    private int swimLimit = 0;
    private double jampLimit = 2.0;

    public Cat() {
        this.runLimit = runLimit * dispersLimit/100;
        this.swimLimit = swimLimit * dispersLimit/100;
        this.jampLimit = jampLimit * dispersLimit/100;
    }

    @Override
    protected void run(int length) {
        System.out.println("результат: run: " + (length <= runLimit ? "true" : "false"));
    }

    @Override
    protected void swim(int length) {
        System.out.println("результат: swim: " + (length <= swimLimit ? "true" : "false"));
    }

    @Override
    protected void jampOver(double hight) {
        System.out.println("результат: jampOver: " + (hight <= jampLimit ? "true" : "false"));
    }

    public void info() {
        System.out.println("Cat: runLimit: " + runLimit + " swimLimit: " + swimLimit + " jampLimit: " + jampLimit);
    }
}
