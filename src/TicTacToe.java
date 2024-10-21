import java.util.Random;
import java.util.Scanner;

/**
 * @author devonline
 * @link http://devonline.academy/java
 */
public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");

        printTableMapping();

        char[][] gameTable = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        if (new Random().nextBoolean()) {
            makeComputerMove(gameTable);
            printGameTable(gameTable);
        }

        while (true) {
            makeUserMove(gameTable);
            printGameTable(gameTable);
            if (isUserWin(gameTable)) {
                System.out.println("You Win!");
                break;
            }
            if (isDraw(gameTable)) {
                System.out.println("Sorry, Draw");
                break;
            }
            makeComputerMove(gameTable);
            printGameTable(gameTable);
            if (isComputerWin(gameTable)) {
                System.out.println("Computer Win!");
                break;
            }
            if (isDraw(gameTable)) {
                System.out.println("Sorry, Draw");
                break;
            }
            // break;
        }
        System.out.println("Game Over!");

    }

    private static void printTableMapping() {
        char[][] mappingTable = {
                {'7', '8', '9'},
                {'4', '5', '6'},
                {'1', '2', '3'}
        };
        printGameTable(mappingTable);
    }

    private static void printGameTable(char[][] gameTable) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + gameTable[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    private static void makeUserMove(char[][] gameTable) {
        while (true) {
            System.out.println("Please type number between 1 and 9:");
            String string = new Scanner(System.in).nextLine();
            if (string.length() == 1) {
                char number = string.charAt(0);
                if (number > '0' && number <= '9') {
                    if (makeUserMoveToCell(gameTable, number)) {
                        return;
                    }
                }
            }
        }
    }

    private static boolean makeUserMoveToCell(char[][] gameTable, char number) {
        char[][] mappingTable = {
                {'7', '8', '9'},
                {'4', '5', '6'},
                {'1', '2', '3'}
        };
        for (int i = 0; i < mappingTable.length; i++) {
            for (int j = 0; j < mappingTable.length; j++) {
                if (number == mappingTable[i][j]) {
                    if (gameTable[i][j] == ' ') {
                        gameTable[i][j] = 'x';
                        return true;
                    } else {
                        System.out.println("Can't make a move, because the cell is not free! Try again!");
                        return false;
                    }
                }
            }
        }
        return false;
    }

    private static void makeComputerMove(char[][] gameTable) {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (gameTable[row][col] == ' ') {
                gameTable[row][col] = '0';
                System.out.println("Computer made a move!");
                return;
            }
        }
    }

    private static boolean isUserWin(char[][] gameTable) {
        return isWinner(gameTable, 'x');
    }

    private static boolean isComputerWin(char[][] gameTable) {
        return isWinner(gameTable, '0');
    }

    private static boolean isWinner(char[][] gameTable, char ch) {
        for (int i = 0; i < 3; i++) {
            if (gameTable[i][0] == gameTable[i][1] && gameTable[i][1] == gameTable[i][2] && gameTable[i][0] == ch) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gameTable[0][i] == gameTable[1][i] && gameTable[1][i] == gameTable[2][i] && gameTable[0][i] == ch) {
                return true;
            }
        }
        if (gameTable[0][0] == gameTable[1][1] && gameTable[1][1] == gameTable[2][2] && gameTable[0][0] == ch) {
            return true;
        }
        if (gameTable[0][2] == gameTable[1][1] && gameTable[1][1] == gameTable[2][0] && gameTable[0][2] == ch) {
            return true;
        }
        return false;
    }

}
