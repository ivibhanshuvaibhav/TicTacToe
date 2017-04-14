package TicTacToe;

public class Board {

    private char[][] board;
    private char player1symbol;
    private char player2symbol;
    public static final int DRAW = 1;
    public static final int PLAYER1 = 2;
    public static final int PLAYER2 = 3;
    public static final int NOT_FINISHED = 4;

    public Board(char player1symbol, char player2symbol){
        this.player1symbol = player1symbol;
        this.player2symbol = player2symbol;

        board = new char[3][3];

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                board[i][j] = '-' ;
            }
        }
    }

    public void referenceMatrix(){

        System.out.println("Matrix for reference");

        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                System.out.print("\t(" + i + "," + j + ")\t");
            }
            System.out.println();
        }
    }

    public void print(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print("\t" + board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void makeMove(int x, int y, char symbol) throws InvalidMoveException{
        if (x < 0 || x > 2 || y < 0 || y > 2 || board[x][y] != '-'){
            InvalidMoveException e = new InvalidMoveException();
            throw e;
        }

        board[x][y] = symbol;
    }

    public int getStatus(){

        for (int i = 0; i < 3; i++){
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                char symbol = board[i][1];
                if (symbol == player1symbol){
                    return PLAYER1;
                } else if (symbol == player2symbol){
                    return PLAYER2;
                } else {
                    return NOT_FINISHED;
                }
            }
        }

        for (int i = 0; i < 3; i++){
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                char symbol = board[1][i];
                if (symbol == player1symbol){
                    return PLAYER1;
                } else if (symbol == player2symbol){
                    return PLAYER2;
                } else {
                    return NOT_FINISHED;
                }
            }
        }

        for (int i = 0; i < 3; i++){
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]){
                char symbol = board[1][1];
                if (symbol == player1symbol){
                    return PLAYER1;
                } else if (symbol == player2symbol){
                    return PLAYER2;
                } else {
                    return NOT_FINISHED;
                }
            }
        }

        for (int i = 0; i < 3; i++){
            if (board[1][2] == board[2][2] && board[2][2] == board[2][1]){
                char symbol = board[1][2];
                if (symbol == player1symbol){
                    return PLAYER1;
                } else if (symbol == player2symbol){
                    return PLAYER2;
                } else {
                    return NOT_FINISHED;
                }
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == '-')
                    return NOT_FINISHED;
            }
        }

        return DRAW;
    }

}
