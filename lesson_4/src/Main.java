import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((map[i][j] == symb && DOTS_TO_WIN <= SIZE - j && right(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == symb && DOTS_TO_WIN <= SIZE - i && down(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == symb && DOTS_TO_WIN <= SIZE - j && DOTS_TO_WIN <= SIZE - i && diag(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == symb && DOTS_TO_WIN <= SIZE - j && DOTS_TO_WIN <= i + 1 && diagUp(i, j, DOTS_TO_WIN - 1, symb))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean right(int i, int j, int n, char symb) {
        int qnt = 0;
        for (int jl = j + 1; jl <= j + n; jl++) {
            if (map[i][jl] == symb) qnt++;
        }
        return qnt == n;
    }

    public static boolean left(int i, int j, int n, char symb) {
        int qnt = 0;
        for (int jl = j - 1; jl >= j - n; jl--) {
            if (map[i][jl] == symb) qnt++;
        }
        return qnt == n;
    }

    public static boolean up(int i, int j, int n, char symb) {
        int qnt = 0;
        for (int il = i - 1; il >= i - n; il--) {
            if (map[il][j] == symb) qnt++;
        }
        return qnt == n;
    }

    public static boolean down(int i, int j, int n, char symb) {
        int qnt = 0;
        for (int il = i + 1; il <= i + n; il++) {
            if (map[il][j] == symb) qnt++;
        }
        return qnt == n;
    }

    public static boolean diag(int i, int j, int n, char symb) {
        int qnt = 0;
        for (int il = i + 1, jl = j + 1; il <= i + n; il++, jl++) {
            if (map[il][jl] == symb) qnt++;
        }
        return qnt == n;
    }

    public static boolean diagUp(int i, int j, int n, char symb) {
        int qnt = 0;
        for (int il = i - 1, jl = j + 1; jl <= j + n; il--, jl++) {
            if (map[il][jl] == symb) qnt++;
        }
        return qnt == n;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = aiNextX();
            y = aiNextY();
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static int aiNextX() {
        char symb = DOT_X;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((map[i][j] == DOT_EMPTY && DOTS_TO_WIN <= SIZE - j && right(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == DOT_EMPTY && DOTS_TO_WIN <= j + 1 && left(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == DOT_EMPTY && DOTS_TO_WIN <= i + 1 && up(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == DOT_EMPTY && DOTS_TO_WIN <= SIZE - i && down(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == DOT_EMPTY && DOTS_TO_WIN <= SIZE - j && DOTS_TO_WIN <= SIZE - i && diag(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == DOT_EMPTY && DOTS_TO_WIN <= SIZE - j && DOTS_TO_WIN <= i + 1 && diagUp(i, j, DOTS_TO_WIN - 1, symb))) {
                    //  System.out.println(j);
                    return j;
                }
            }
        }
        return rand.nextInt(SIZE);
    }

    public static int aiNextY() {
        char symb = DOT_X;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((map[i][j] == DOT_EMPTY && DOTS_TO_WIN <= SIZE - j && right(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == DOT_EMPTY && DOTS_TO_WIN <= j + 1 && left(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == DOT_EMPTY && DOTS_TO_WIN <= i + 1 && up(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == DOT_EMPTY && DOTS_TO_WIN <= SIZE - i && down(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == DOT_EMPTY && DOTS_TO_WIN <= SIZE - j && DOTS_TO_WIN <= SIZE - i && diag(i, j, DOTS_TO_WIN - 1, symb)) ||
                        (map[i][j] == DOT_EMPTY && DOTS_TO_WIN <= SIZE - j && DOTS_TO_WIN <= i + 1 && diagUp(i, j, DOTS_TO_WIN - 1, symb))) {
                    //System.out.println(i);
                    return i;
                }
            }
        }
        return rand.nextInt(SIZE);
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE && map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
