package TicTacToe;

import java.util.Scanner;

public class Game {

    public void run(){

        System.out.println("Player 1");
        Player player1 = Player.takePlayerInput();
        System.out.println("Player 2");
        Player player2 = Player.takePlayerInput();

        while (player1.name.equals(player2.name) || player1.symbol == player2.symbol) {
            System.out.println("Name or symbol is already chosen. Please choose unique.");
            player2 = Player.takePlayerInput();
        }

        Board board = new Board(player1.symbol, player2.symbol);
        Scanner s = new Scanner(System.in);

        System.out.println("Get ready to play");
        board.referenceMatrix();

        boolean isPlayer1 = true;

        Player currentPlayer;

        while (board.getStatus() == Board.NOT_FINISHED){

            if (isPlayer1){
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }

            System.out.println("Its " + currentPlayer.name + "'s turn!");
            System.out.println("Enter x coordinate");
            int x = s.nextInt();
            System.out.println("Enter y coordinate");
            int y = s.nextInt();
                try {
                board.makeMove(x, y, currentPlayer.symbol);
                board.print();
                } catch (InvalidMoveException e){
                    System.out.println("Invalid move!");
                    return;
                }
            isPlayer1 = !isPlayer1;
        }


        int status = board.getStatus();
        if (status == Board.DRAW){
            System.out.println("Draw!");
        } else if (status == Board.PLAYER1){
            System.out.println(player1.name + " won!");
        } else if (status == Board.PLAYER2){
            System.out.println(player2.name + " won!");
        }

        }

    public static void main(String[] args) {

        Game g = new Game();
        g.run();

    }

}
