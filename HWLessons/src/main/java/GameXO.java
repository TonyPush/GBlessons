import java.util.*;

public class GameXO {
    final int size = 3;
    char[][] map = new char[size][size];
    final char cNull = '-', player = 'x', cpu1 = 'o';
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    public static void main(String[] args) {
        GameXO  g = new GameXO();
        g.newMap();
        g.printMap();

        while (true) {
            //ход игрока
            g.playerTurn();
            g.printMap();
            if (g.checkWin(g.player)) { System.out.println("ПОЗДРАВЛЯЕМ! ВЫ ПОБЕДИЛИ!"); break; }
            if (g.isMapFull()) { System.out.println("GAME OVER. НИКТО НЕ ВЫИГРАЛ!"); break; }

            //ход CPU
            g.aiTurn(g.cpu1);
            g.printMap();
            if (g.checkWin(g.cpu1)) { System.out.println("GAME OVER. КОМПЬЮТЕР ВЫИГРАЛ"); break; }
            if (g.isMapFull()) { System.out.println("GAME OVER. НИКТО НЕ ВЫИГРАЛ!"); break; }
        }
    }

    void newMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = cNull;
            }
        }
    }

    void printMap() {
        for (int i = 0; i < size + 1; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.print(">X");
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(" " + (i + 1) + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println(i + 1);
        }
        System.out.print(" Y< ");
        for (int i = 1; i <= size; i++) System.out.print(i + "  ");
        System.out.println("O\n");
    }

    void playerTurn() {
        int x, y;
        do {
            System.out.println("ВАШ ХОД. Введите координаты >X и Y<");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            //System.out.println("Вы ввели координаты: x = " + (x + 1) + ", y = " + (y + 1));
        } while (!isCellValid(x, y));
        map[y][x] = player;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) return false;
        if (map[y][x] == cNull) return true;
        return false;
    }

    boolean checkWin(char c) {
        int countV;
        int countH;
        int countDiagonalA = 0;
        int countDiagonalB = 0;
        for (int i = 0; i <= size - 1; i++) {
            countH = 0;
            countV = 0;
            for (int j = 0; j <= size - 1; j++) {
                //проверка  по горизонтали
                if (map[i][j] == c) {
                    countH++;
                    if (countH == size) return true;
                }

                //проверка  по вертикали
                if (map[j][i] == c) {
                    countV++;
                    if (countV == size) return true;
                }
            }

            // проверка  диагонали А "\"
            if (map[i][i] == c) {
                countDiagonalA++;
                if (countDiagonalA == size) return true;
            } else countDiagonalA = 0;

            // проверка  диагонали B "/"
            if (map[i][size - 1 - i] == c) {
                countDiagonalB++;
                if (countDiagonalB == size) return true;
            } else countDiagonalB = 0;
        }
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == cNull) return false;
            }
        }
        return true;
    }

    void aiTurn(char c) {
        int x = 0, y = 0, countH = 0, countHNull = 0, countV = 0, countVNull = 0, countDiagonalA = 0, countDiagonalB = 0, countDANull = 0, countDBNull = 0;

        System.out.println("CPU сделал свой ход [" + c +"]:");

        // 1. Атакуем игрока
        for (int i = 0; i < size; i++) {
            countH = 0;
            countHNull = 0;
            countV = 0;
            countVNull = 0;
            for (int j = 0; j < size; j++) {
                //правильный Вертикальный ход
                if (map[j][i] == c) countV++;
                else if (map[j][i] == cNull) countVNull++;
                if ((countV == size - 1) && (countVNull == 1)) {
                    //System.out.println("CPU почти выиграл! верт. line = " + (i + 1)); // i - верт. line
                    for (int k = 0; k < size; k++) {
                        if (map[k][i] == cNull) {
                            map[k][i] = c;
                            return;
                        }
                    }
                }
                //правильный Горизоньальный ход
                if (map[i][j] == c) countH++;
                else if (map[i][j] == cNull) countHNull++;
                if ((countH == size - 1) && (countHNull == 1)) {
                    //System.out.println("CPU почти выиграл! горизонт. line = " + (i + 1)); // i - горизонт. line
                    for (int k = 0; k < size; k++) {
                        if (map[i][k] == cNull) {
                            map[i][k] = c;
                            return;
                        }
                    }
                }

            }

            // // правильная диагональ  A "\" ходов
            if (map[i][i] == c) countDiagonalA++;
            else if (map[i][i] == cNull) countDANull++;
            if ((countDiagonalA == size - 1) && (countDANull == 1)) {
                //System.out.println("CPU почти выиграл! diagA линия \\");
                for (int j = 0; j < size; j++) {
                    if (map[j][j] == cNull) {
                        map[j][j] = c;
                        return;
                    }
                }
            }

            // // правильная диагональ  B "/" ходов
            if (map[i][size - 1 - i] == c) countDiagonalB++;
            else if (map[i][size - 1 - i] == cNull)  countDBNull++;
            if ((countDiagonalB == size - 1) && (countDBNull == 1)) {
                //System.out.println("CPU почти выиграл! diagB линия /");
                for (int j = 0; j < size; j++) {
                    if (map[j][size - 1 - j] == cNull) {
                        map[j][size - 1 - j] = c;
                        return;
                    }
                }
            }
        }

        countH = 0;
        countHNull = 0;
        countV = 0;
        countVNull = 0;
        countDiagonalA = 0;
        countDiagonalB = 0;
        countDANull = 0;
        countDBNull = 0;

        // 2. Блокировка ходов игрока
        for (int i = 0; i < size; i++) {
            countH = 0;
            countHNull = 0;
            countV = 0;
            countVNull = 0;
            for (int j = 0; j < size; j++) {
                //правильный Вертикальный ход
                if (map[j][i] == player) countV++;
                else if (map[j][i] == cNull) countVNull++;
                if ((countV == size - 1) && (countVNull == 1)) {
                    //System.out.println("Предупреждение для CPU! верт. line = " + (i + 1)); // i - вертикальная линия
                    for (int k = 0; k < size; k++) {
                        if (map[k][i] == cNull) {
                            map[k][i] = c;
                            return;
                        }
                    }
                }
                //правильный Горизонтальный ход
                if (map[i][j] == player) countH++;
                else if (map[i][j] == cNull) countHNull++;
                if ((countH == size - 1) && (countHNull == 1)) {
                    //System.out.println("Предупреждение для CPU! горизонт. line = " + (i + 1)); // i - горизон. линия
                    for (int k = 0; k < size; k++) {
                        if (map[i][k] == cNull) {
                            map[i][k] = c;
                            return;
                        }
                    }
                }

            }

            // правильная диагональ  А "\" ходов
            if (map[i][i] == player) countDiagonalA++;
            else if (map[i][i] == cNull) countDANull++;
            if ((countDiagonalA == size - 1) && (countDANull == 1)) {
                //System.out.println("Предупреждение для CPU! диаг.A линия\\");
                for (int j = 0; j < size; j++) {
                    if (map[j][j] == cNull) {
                        map[j][j] = c;
                        return;
                    }
                }
            }

            // правильная диагональ  B "/" ходов
            if (map[i][size - 1 - i] == player) countDiagonalB++;
            else if (map[i][size - 1 - i] == cNull)  countDBNull++;
            if ((countDiagonalB == size - 1) && (countDBNull == 1)) {

                for (int j = 0; j < size; j++) {
                    if (map[j][size - 1 - j] == cNull) {
                        map[j][size - 1 - j] = c;
                        return;
                    }
                }
            }
        }

        // 3. Taking center of map
        if (!(size % 2 == 0)) {
            int center = (((size + 1) / 2) - 1);
            if (map[center][center] == cNull) {
                map[center][center] = c;
                return;
            }
        }

        // 4. Taking diagonal points of map
        if (map[0][0] == cNull) { map[0][0] = c; return; }
        if (map[0][map.length - 1] == cNull) { map[0][map.length - 1] = c; return; }
        if (map[map.length - 1][0] == cNull) { map[map.length - 1][0] = c; return; }
        if (map[map.length - 1][map.length - 1] == cNull) { map[map.length - 1][map.length - 1] = c; return; }

        // 5. random move
        //System.out.println("AI random");
        do {
            x = r.nextInt(size);
            y = r.nextInt(size);
        } while (!isCellValid(x, y));
        map[y][x] = c;
        System.out.println("AI X: " + (x + 1) + " Y: " + (y + 1));
    }
}