package YandexAlgoritms5.badSol;

import java.util.Scanner;

public class ChessBoard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[8][8];


        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < 8; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        scanner.close();

        int count = 0;


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == '*') {
                    if (!isCellUnderAttack(i, j, board)) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    // Проверяем, бьется ли клетка фигурами
    public static boolean isCellUnderAttack(int row, int col, char[][] board) {
        // Проверяем горизонталь и вертикаль
        for (int i = 0; i < 8; i++) {
            if (board[row][i] == 'R' || board[i][col] == 'R') {
                return true;
            }
        }

        // Проверяем диагонали
        int i = row, j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'B') {
                return true;
            }
            i--;
            j--;
        }

        i = row;
        j = col;
        while (i >= 0 && j < 8) {
            if (board[i][j] == 'B') {
                return true;
            }
            i--;
            j++;
        }

        i = row;
        j = col;
        while (i < 8 && j >= 0) {
            if (board[i][j] == 'B') {
                return true;
            }
            i++;
            j--;
        }

        i = row;
        j = col;
        while (i < 8 && j < 8) {
            if (board[i][j] == 'B') {
                return true;
            }
            i++;
            j++;
        }

        return false;
    }
}
