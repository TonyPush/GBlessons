import java.sql.SQLOutput;

public class Arrays {

    public static void main(String[] args) {
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();
        maxMinArray();
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(nPositionMove(new int[]{1, 2, 3, 4, 5, 6, 7}, -3));


    }

    public static void invertArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case 1:
                    array[i] = 0;
                    System.out.print(array[i]);
                    System.out.print(" ");
                    break;
                case 0:
                    array[i] = 1;
                    System.out.print(array[i]);
                    System.out.print(" ");
                    break;
                default:
                    System.out.println("Неверное значение массива");
            }
        }
        System.out.println();
    }

    public static void fillArray() {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void changeArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void fillDiagonal() {
        int[][] array = new int[6][6];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + " ");

            }
            System.out.println();
            System.out.println();
        }
    }

    public static void maxMinArray() {
        int[] array = {2, 5, 9, 17, 50, 100};
        int max = 0, min = 9999999;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= min) min = array[i];

            if (array[i] >= max) max = array[i];
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("max = " + max + " , min = " + min);
        System.out.println();
    }

    public static boolean checkBalance(int[] array) {

        int sumArr = 0;
        int checkArr = 0;
        int firstPart = 0;
        int secondPart = 0;

        for (int i = 0; i < array.length; i++) sumArr += array[i];
        int check = sumArr / 2;

        for (int i = 0; i < array.length; i++) {
            if (checkArr < sumArr / 2) {
                firstPart += array[i];
            }
            if (checkArr >= sumArr / 2) {
                secondPart += array[i];
            }
            checkArr += array[i];
        }

        if (secondPart == firstPart) {
            return true;
        } else {
            return false;
        }
    }

    public static String nPositionMove(int[] array, int n) {
        String arr = "";
        System.out.println();
        for (int i = 0; i < array.length; i++) arr += array[i] + " ";

        System.out.print("Before: " + arr);
        System.out.println(" (n = " + n + ")");
        arr = "After:  ";

        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int temp = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = temp;
            }

            for (int i = 0; i < array.length; i++) arr += array[i] + " ";

            return arr;

        } else if (n < 0) {
            for (int i = 0; i < n * (-1); i++) {
                int temp = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = temp;
            }

            for (int i = 0; i < array.length; i++) arr += array[i] + " ";

            return arr;

        } else { //если будет введн n = 0
        for (int i = 0; i < array.length; i++) arr += array[i] + " ";
        return arr;
    }
    }
}

