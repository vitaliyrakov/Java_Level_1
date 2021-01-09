
public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite))
            this.fullness = true;
    }

    String getName() {
        return name;
    }

    boolean getFullness() {
        return this.fullness;
    }
}