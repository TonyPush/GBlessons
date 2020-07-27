import com.sun.source.tree.IfTree;

import java.util.Random;
import java.util.Scanner;

public class GuessFood {

    public static void main(String[] args) {


        hello();
        guessGame();
    }
        public static String randomWord(String[] word) {

            Random random = new Random();
            return word[random.nextInt(word.length - 1)].toLowerCase();
        }


        public static void hello() {

            System.out.println();
            System.out.println("Добрый день! Вас приветсвует игра \"Угадай слово\"");
            System.out.println("Вам нужно отгадать овощ или фрукт. Для этого введите слово на аглийском");
            System.out.println();

            String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                    "avocado", "broccoli", "carrot", "cherry", "garlic",
                    "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                    "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                    "pumpkin", "potato"};
            System.out.println("Мы загадали одно из этих слов: ");
            for (int i = 0; i < words.length; i++) {
                if (i < 7) System.out.print(words[i] + "  |  ");
                if (i == 7) System.out.println();
                if (8 < i && i < 16) System.out.print(words[i] + "  |  ");
                if (i == 16) System.out.println();
                if (16 < i && i < words.length) System.out.print(words[i] + "  |  ");
            }

        }

        public static void guessGame() {
            String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                    "avocado", "broccoli", "carrot", "cherry", "garlic",
                    "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                    "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                    "pumpkin", "potato"};
            String food = randomWord(words);

            String guessWord = "";
            while (true) {
                System.out.println();
                System.out.println("-----------------------------------------------------");
                System.out.println("Пожалуйста, введите название фрукта или овоща");
                Scanner scanner = new Scanner(System.in);


                guessWord = scanner.nextLine().toLowerCase();
                if (guessWord.equals(food)) {
                    System.out.println("Поздравляем! " + " Вы отгадали слово!\n");
                    System.out.println("Игра закончена!");
                    break;
                }

                if (true) {
                    if ((food.length() != guessWord.length()) && (((food.length() >= guessWord.length())))) {
                        System.out.println("##############");
                        System.out.println("Увы, загадано другое слово\n");
                        continue;
                    }
                    for (int i = 0; i < food.length(); i++) {

                        if (food.charAt(i) == guessWord.charAt(i))
                            System.out.print(guessWord.charAt(i));
                        else {
                            System.out.print("#");
                        }
                    }


                    if (((food.length() >= guessWord.length()) || (food.length() <= guessWord.length())) || (!guessWord.equals(food)))
                        System.out.println("##############");
                    System.out.println("Увы, загадано другое слово\n");
                }
            }
        }
    }