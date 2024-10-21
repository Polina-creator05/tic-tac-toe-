import java.util.Random;

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
}
