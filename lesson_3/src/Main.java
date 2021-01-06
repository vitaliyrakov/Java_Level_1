import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        guessNumber();
    }

    public static void guessNumber() {
        // Написать программу, которая загадывает случайное число от 0 до 9,
        // и пользователю дается 3 попытки угадать это число.
        // При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        final int TRYNUMBER = 3;
        final int BOUND = 10;

        do {
            int number = rand.nextInt(BOUND);
            System.out.println("Введите число от 0 до " + BOUND + " (у вас " + TRYNUMBER + " попытки): ");
            for (int i = 0; i < TRYNUMBER; i++) {
                int inputNumber = sc.nextInt();
                if (inputNumber == number) {
                    System.out.println("Вы угадали");
                    break;
                } else System.out.println("Загаданное число " + (inputNumber < number ? "больше" : "меньше"));
            }

            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        } while (sc.nextInt() == 1);
        sc.close();
    }

}
