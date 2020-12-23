
public class Plate {
    private int food;
    private int plateLimit;

    public Plate(int food, int plateLimit) {
        this.food = food;
        this.plateLimit = plateLimit;
    }

    public boolean decreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        } else {
            System.out.println("Не достаточно еды в тарелке, котик, извини.");
            return false;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood(int n) {
        if (food + n <= plateLimit) {
            food += n;
        } else {
            food = plateLimit;
            System.out.println("Тарелка полная.");
        }
    }
}