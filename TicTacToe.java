import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++){
                board[row][col] = ' ';

            }
        }
        char player = 'x';
        boolean gameover = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameover){
            printBoard(board);
            System.out.println("player" + player + "enter");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == ' '){
                board[row][col] = player; //place the element
                gameover = haveWon(board, player);
                if (gameover){
                    System.out.println("player" + player + "has won: ");
                } else{
                    player = (player == 'x') ? '0' : 'x';
                  }
            } else {
                System.out.println("Invalid move. Try again!");
            }

        }
        printBoard(board);



    }
    public static boolean haveWon(char[][] board, char player){
        // check the rows
        for (int row = 0; row < board.length; row++){
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        // check for col
        for (int col = 0; col < board[0].length; col++){
            if (board[0][col] == player && board[1][col] == player &&  board[2][col] == player){
                return true;
            }
        }
        // diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;

        }
            return false;

    }

    public static void printBoard(char[][] board){
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++){
                System.out.println(board[row][col] + " | ");
            }
            System.out.println();
        }

    }
}
