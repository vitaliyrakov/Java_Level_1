public class Main {
    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {

        // 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte byteVar = 100;
        short shortVar = 200;
        int intVar = -1000;
        long longVar = 2000L;

        float floatVar = 10.5f;
        double doubleVar = 20.5;

        boolean boolVar = true;

        char charVar = 'q';
        String stringVar = "hello";

        System.out.println("3. результат работы метода calcMeth: " + calcMeth(byteVar, shortVar, intVar, longVar));
    }

    // 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода
    public static double calcMeth(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }
}
