import java.util.Scanner;

public class Pawn extends GamePieces{

    int x = 5;
    int y = 1;

    public Pawn(int x, int y) {
        super(x, y);
    }

    public void movePawn(GamePieces[][] board) {
        System.out.println("Which way would you like to move the player?\n");
        Scanner s = new Scanner(System.in);
        String move = s.nextLine();
        if(move.equals("up")) {
            if(determineTopBlocking(board)) {
                x++;
            }
            else {
                System.out.println("That move is blocked. Choose another.\n");
                move = s.nextLine();
            }
        }

        if(move.equals("left")) {
            if(determineLeftBlocking(board)) {
                y--;
            }
            else {
                System.out.println("That move is blocked. Choose another.\n");
                move = s.nextLine();
            }
        }

        if(move.equals("right")) {
            if(determineRightBlocking(board)) {
                y++;
            }
            else {
                System.out.println("That move is blocked. Choose another.\n");
            }
        }

        if(move.equals("down")) {
            if(determineBotBlocking(board)) {
                x--;
            }
            else {
                System.out.println("That move is blocked. Choose another.\n");
            }

        }
    }

    public boolean determineTopBlocking(GamePieces[][] board) {
        return board[x + 1][y] == null;
    }

    public boolean determineRightBlocking(GamePieces[][] board){
        return board[x][y + 1] == null;
    }

    public boolean determineLeftBlocking(GamePieces[][] board){

        return board[x][y - 1] == null;
    }

    public boolean determineBotBlocking(GamePieces[][] board){
        return board[x - 1][y] == null;

    }

    public boolean CheckPlayerValid(GamePieces[][] board){

        return x % 2 == 1 && y % 2 == 1;

    }

    public boolean determineWin(){

        return x - 18 == 1 || x + 18 == 19;

    }

}