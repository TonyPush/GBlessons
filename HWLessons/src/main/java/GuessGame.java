import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    public static void main(String[] args) {
    hello();

    game();

    }

    public static void game() {
        int num = 0;
        int guessPlayer = 0;
        int tryRow = 1;
        int choice;
        Random random = new Random();
        num = random.nextInt(10);
        Scanner scanner = new Scanner(System.in);

        while (tryRow < 4) {
            System.out.println("------------------------------------------------");
            System.out.println();
            System.out.println("Введите любое число от 0 до 9: ");
            guessPlayer = scanner.nextInt();

            if (num == guessPlayer) {
                System.out.println("Поздравляем! Вы угадали задуманное число!" + " (c " + tryRow + "-ой" + " попытки)");
                System.out.println();
                break;

            } else {
                System.out.println("Увы, не угадали.");

                if (num < guessPlayer) System.out.print("Загаданное число меньше " + guessPlayer);
                else System.out.print("Загаданное число больше " + guessPlayer);

                System.out.println(" || Число попыток: " + (3 - tryRow));
                tryRow++;
                if (tryRow == 4){
                    System.out.println();
                    System.out.println(" Вы проиграли.. ");
                }

            }
        }
        nextGame();
    }

    public static void nextGame() {
        System.out.println();
        System.out.println("Повторить игру еще раз?\n" + "1 – да / 0 – нет");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) game();
        else System.out.println("Игра закончена..");
    }

    public static void hello() {
        System.out.println("Здравствуйте! Вас приветствует игра \"Угадай число\"");
        System.out.println("Вам нужно отгадать число от 0 до 9");
    }

}

