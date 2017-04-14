package TicTacToe;

import java.util.Scanner;

public class Player {

    public String name;
    public char symbol;
    static Scanner s = new Scanner(System.in);

    public static Player takePlayerInput(){
        System.out.println("Enter name:");
        String name = s.next();
        System.out.println("Enter symbol:");
        char symbol = s.next().charAt(0);

        return new Player(name, symbol);
    }

    public Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }
}
