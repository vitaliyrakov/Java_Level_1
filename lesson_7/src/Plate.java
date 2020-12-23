
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
            System.out.println("Не достаточное еды в тарелке, котик, извини.");
            return false;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public boolean addFood(int n) {
        if (food + n <= plateLimit) {
            food += n;
            return true;
        } else {
            food = plateLimit;
            System.out.println("Тарелка полная.");
            return false;
        }
    }
}