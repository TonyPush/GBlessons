public class FirstApp {

    public static void main(String[] args) {

        byte by = 120;
        char ch = 'c';
        short sh = 31254;
        int in = 257324;
        long lo = 254000000;
        float fl = 527.257f;
        double dou = 12310449.580363;
        boolean yes = true;
        boolean noChance = false;

        calculate(13,8,10,5);
        System.out.println(task10and20(8,1));
        isPositiveOrNegative(0);
        System.out.println(isNegative(-3));
        greetings("Вася");
        bissextile(3008);
    }

    public static int calculate(int a, int b, int c, int d) {
        int calc = a * (b + (c / d));
        System.out.println(calc);
        return calc;
    }

    public static boolean task10and20(int x1, int x2) {
        int sum = x1 + x2;
        if (sum >= 10 && sum <= 20) {
            return true;
        }
        return false;
    }

    public static void isPositiveOrNegative(int x) {
        if( x >= 0) {
            System.out.println("Вы передали положительное число");
        } else {
            System.out.println("Вы передали отрицательное число");
        }
    }

    public static boolean isNegative(int x) {
        if(x < 0) {
            return true;
        }
        return false;
    }

    public static void greetings(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void bissextile(int year) {
        if (year > 0 && year <= 9999) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.println("Год високосный");
            } else {
                System.out.println("Обычный год");
            }
        } else {
            System.out.println("Введено некорректное значение года");
        }
    }

}
