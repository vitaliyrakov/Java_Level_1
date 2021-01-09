
public class MainOop {
    public static void main(String[] args) {
        Cat[] cat = {
                new Cat("Barsik", 5),
                new Cat("Murzik", 10),
                new Cat("Rigik", 15),
                new Cat("Vaska", 20)
        };
        Plate plate = new Plate(100, 200);
        // инфо о тарелке
        plate.info();
        for (Cat c : cat) {
            System.out.println(c.getName() + " сытость: " + (c.getFullness() ? " сыт и доволен" : "голоден как волк"));
        }
        for (Cat c : cat) {
            c.eat(plate);
        }
        for (Cat c : cat) {
            System.out.println(c.getName() + " сытость: " + (c.getFullness() ? " сыт и доволен" : "голоден как волк"));
        }

        plate.info();
        System.out.println("Ну вы и пожрать!");
        plate.addFood(151);
        plate.info();
    }
}
