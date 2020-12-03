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

        System.out.println("4.");
        System.out.println(" результат работы метода isSumBetween10_20(" + byteVar + "," + shortVar + "): " + isSumBetween10_20(byteVar, shortVar));
        System.out.println(" результат работы метода isSumBetween10_20(" + 5 + "," + 12 + "): " + isSumBetween10_20(5, 12));

        System.out.println("5.");
        printSignNomber(-10);
        printSignNomber(100);

        System.out.println("6.");
        System.out.println(" результат работы метода isNegativNumber(" + longVar + "): " + isNegativNumber(longVar));
        System.out.println(" результат работы метода isNegativNumber(" + intVar + "): " + isNegativNumber(intVar));

        System.out.print("7. ");
        printHello("Вася");

    }

    // 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода
    public static double calcMeth(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    /* 4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
     если да – вернуть true, в противном случае – false */
    public static boolean isSumBetween10_20(double a, double b) {
        boolean cond;
        if (a + b >= 10 && a + b <= 20) cond = true;
        else cond = false;
        return cond;
    }

    /*5. Написать метод, которому в качестве параметра передается целое число,
     метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.  */
    public static void printSignNomber(long number) {
        String sign;
        if (number >= 0) sign = " положительное";
        else sign = " отрицательное";
        System.out.println(" Число " + number + sign);
    }

    // 6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное
    public static boolean isNegativNumber(long number) {
        return number < 0;
    }

    // 7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»
    public static void printHello(String name) {
        System.out.println("Привет, " + name);
    }
    
}
