public class Main {

    public static void main(String[] args) {

        /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0; */
        int[] intArr = {1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1};
        System.out.print("1. Было:  ");
        for (int m : intArr) System.out.print(m + " ");

        int i;
        for (i = 0; i < intArr.length; i++) {
            if (intArr[i] == 1) {
                intArr[i] = 0;
            } else {
                intArr[i] = 1;
            }
        }
        System.out.println();
        System.out.print("   Стало: ");
        for (int m : intArr) System.out.print(m + " ");

        // 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] intArr2 = new int[8];
        int j;
        for (i = 0, j = 0; i < intArr2.length; i++, j += 3) {
            intArr2[i] = j;
        }
        System.out.println();
        System.out.print("2. Результатирующий массив: ");
        for (int m : intArr2) System.out.print(m + " ");

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] intArr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println();
        System.out.print("3. Было:  ");
        for (int m : intArr3) System.out.print(m + " ");

        for (i = 0; i < intArr3.length; i++) {
            if (intArr3[i] < 6) {
                intArr3[i] *= 2;
            }
        }
        System.out.println();
        System.out.print("   Стало: ");
        for (int m : intArr3) System.out.print(m + " ");

        // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] sqArr = new int[5][5];
        for (i = 0; i < sqArr.length; i++) {
            for (j = 0; j < sqArr[0].length; j++) {
                if (i == j) sqArr[i][j] = 1;
            }
        }
        System.out.println();
        System.out.println("4. ");
        for (i = 0; i < sqArr.length; i++) {
            for (j = 0; j < sqArr[0].length; j++) {
                System.out.print(sqArr[i][j]);
            }
            System.out.println();
        }

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] sArr = {1, 5, 9, 3, 7, 5, 6, 1, 8, 5, 9};
        int minElem = sArr[0], maxElem = 0;
        for (int m : sArr) {
            minElem = minElem > m ? m : minElem;
            maxElem = maxElem < m ? m : maxElem;
        }
        System.out.println("5. ");
        System.out.println("минимальный элемент: " + minElem);
        System.out.println("максимальный элемент: " + maxElem);

        // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) ? true, checkBalance([1, 1, 1, || 2, 1]) ? true,
        // граница показана символами ||, эти символы в массив не входят.
        int[] intArr4 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("6. результат работы метода checkBalance: " + checkBalance(intArr4));


        // 7. **** Написать метод, которому на вход подается одномерный массив и число n
        // (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        System.out.println("7. ");
        System.out.print(" исходный массив: ");
        for (int m : intArr4) System.out.print(m + " ");
        System.out.println();
        offsetElem(intArr4, -3);
        System.out.print(" после сдвига:    ");
        for (int m : intArr4) System.out.print(m + " ");
    }

    public static boolean checkBalance(int[] arr) {
        int i, j, sumLeft = 0;
        boolean balance = false;
        for (i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            int sumRight = 0;
            for (j = arr.length - 1; j > i; j--) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) {
                balance = true;
                break;
            }
        }
        return balance;
    }

    public static void offsetElem(int[] arr, int offset) {
        int i, j, oldNum, curNum;
        oldNum = curNum = 0;
        for (i = 0; i < offset; i++) {   // производим в цикле сдвиг на offset
            for (j = 0; j < arr.length; j++) {   //проходим по всему массиву и сдвигаем на 1 позицию вправо
                if (j == 0) {
                    oldNum = arr[j];
                    arr[j] = arr[arr.length - 1];
                } else {
                    curNum = arr[j];
                    arr[j] = oldNum;
                    oldNum = curNum;
                }
            }
        }

        oldNum = curNum = 0;
        for (i = 0; i > offset; i--) {
            for (j = arr.length - 1; j >= 0; j--) {   //проходим по всему массиву и сдвигаем на 1 позицию влево
                if (j == arr.length - 1) {
                    oldNum = arr[j];
                    arr[j] = arr[0];
                } else {
                    curNum = arr[j];
                    arr[j] = oldNum;
                    oldNum = curNum;

                }
            }
        }
    }
}