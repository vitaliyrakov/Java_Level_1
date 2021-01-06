import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        guessNumber();
        guessWord();
    }

    private static void guessNumber() {
        /* 1. Написать программу, которая загадывает случайное число от 0 до 9,
        и пользователю дается 3 попытки угадать это число.
        При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
        После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет). */
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

    private static void guessWord() {
        /* 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
     Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно, можно пользоваться:
        String str = "apple";
        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово
        Используем только маленькие буквы
          */
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        String showWord;
        do {
            String randomWord = words[rand.nextInt(words.length)];
            System.out.println("Введите загаданное слово): ");
            while (true) {
                String inputWord = sc.next();
                if (inputWord.equalsIgnoreCase(randomWord)) {
                    System.out.println("Вы угадали");
                    break;
                } else {
                    showWord = "";
                    for (int i = 0; (i < randomWord.length() && i < inputWord.length()); i++) {
                        showWord += (randomWord.charAt(i) == inputWord.charAt(i)) ? randomWord.charAt(i) : '#';
                    }
                    System.out.println("Вы не угадали: " + String.format("%-15s", showWord).replace(' ', '#'));
                }
            }

            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        } while (sc.nextInt() == 1);
        sc.close();
    }

}
