package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    private static char[][] matrix = new char[4][4];

    public TicTacToe(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                matrix[i][j] = '-';
            }
        }
    }

    public static void referenceMatrix(){

        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                System.out.print("\t(" + i + "," + j + ")\t");
            }
            System.out.println();
        }
    }

    public static void setMatrix(int x, int y, char symbol){

        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (i == x && j == y)
                    matrix[i][j] = symbol;
            }
        }
    }

    public static void printMatrix(){

        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                System.out.print("\t" + matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean checkResult() {
        if ((matrix[0][0] == 'x' && matrix[0][1] == 'x' && matrix[0][2] == 'x') ||
                (matrix[1][0] == 'x' && matrix[1][1] == 'x' && matrix[1][2] == 'x') ||
                (matrix[2][0] == 'x' && matrix[2][1] == 'x' && matrix[2][2] == 'x') ||
                (matrix[0][0] == 'x' && matrix[1][0] == 'x' && matrix[2][0] == 'x') ||
                (matrix[0][1] == 'x' && matrix[1][1] == 'x' && matrix[2][1] == 'x') ||
                (matrix[0][2] == 'x' && matrix[1][2] == 'x' && matrix[2][2] == 'x') ||
                (matrix[0][0] == 'x' && matrix[1][1] == 'x' && matrix[2][2] == 'x') ||
                (matrix[2][0] == 'x' && matrix[1][1] == 'x' && matrix[0][2] == 'x') ||
                (matrix[0][0] == 'o' && matrix[0][1] == 'o' && matrix[0][2] == 'o') ||
                (matrix[1][0] == 'o' && matrix[1][1] == 'o' && matrix[1][2] == 'o') ||
                (matrix[2][0] == 'o' && matrix[2][1] == 'o' && matrix[2][2] == 'o') ||
                (matrix[0][0] == 'o' && matrix[1][0] == 'o' && matrix[2][0] == 'o') ||
                (matrix[0][1] == 'o' && matrix[1][1] == 'o' && matrix[2][1] == 'o') ||
                (matrix[0][2] == 'o' && matrix[1][2] == 'o' && matrix[2][2] == 'o') ||
                (matrix[0][0] == 'o' && matrix[1][1] == 'o' && matrix[2][2] == 'o') ||
                (matrix[2][0] == 'o' && matrix[1][1] == 'o' && matrix[0][2] == 'o')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter name of player 1: ");
        String name1 = s.nextLine();

        System.out.println("Enter name of player 2: ");
        String name2 = s.nextLine();

        System.out.println("Enter symbol for " + name1 + " (x|o): ");
        char symbol1 = s.next().charAt(0);
        char symbol2;

        if(symbol1 == 'x'){
            symbol2 = 'o';
        } else {
            symbol2 = 'x';
        }

        System.out.println("Symbol for " + name1 + " is " + symbol1);
        System.out.println("Symbol for " + name2 + " is " + symbol2);

        System.out.println("Let's play");

        System.out.println(name1 + " goes first");

        System.out.println("Coordinates for matrix");
        referenceMatrix();

        for (int i=1; i<=9; i++) {
            if (i % 2 == 1) {
                System.out.println("Enter coordinates for " + name1 + "'s(" + symbol1 + ") turn");
                int x = s.nextInt();
                int y = s.nextInt();
                setMatrix(x, y, 'x');

            } else {
                System.out.println("Enter coordinates for " + name2 + "'s(" + symbol2 + ") turn");
                int x = s.nextInt();
                int y = s.nextInt();
                setMatrix(x, y, 'o');
            }
            printMatrix();
            if (i >= 5) {
                boolean result = checkResult();
                if (result) {
                    if (i % 2 == 1){
                        System.out.println(name1 + " has Won. Congratulations!");
                    } else {
                        System.out.println(name2 + " has Won. Congratulations!");
                    }
                    return;
                }
            }
        }
    }
}
