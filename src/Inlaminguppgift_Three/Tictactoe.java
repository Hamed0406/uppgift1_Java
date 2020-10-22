package Inlaminguppgift_Three;

import java.util.Scanner;

public class Tictactoe {

    public  static void main(String args[])
    {


        int playerOneScore=0,playerTwoScore=0;
        boolean altenativeFlag=false;//for choice if they want to continue
        char[][] board = new char[3][3];

        Scanner in = new Scanner(System.in);
        System.out.println("Wholesome to Tic Tac Toe! You know the rolls lets Start with your name ");
        System.out.print("Player 1, what is your name? ");
        String playerOne = in.nextLine();
        System.out.println("Welcomed to the game "+playerOne);
        System.out.print("Player 2, what is your name? ");
        String playerTwo = in.nextLine();
        System.out.println("Welcomed to the game " +playerTwo);
while(!altenativeFlag){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }



        //Create a player1 boolean that is true if it is player 1's turn and false if it is player 2's turn
        boolean player1 = true;

        //Create a gameEnded boolean and use it as the condition in the while loop
        boolean gameEnded = false;
        while(!gameEnded) {

            //Draw the board
            printBored(board);

            //Print whose turn it is
            if (player1) {
                System.out.println(playerOne + "'s Turn (x):");
            } else {
                System.out.println(playerTwo + "'s Turn (o):");
            }

            //Create a char variable that stores either 'x' or 'o' based on what player's turn it is
            char c = '-';
            if (player1) {
                c = 'x';
            } else {
                c = 'o';
            }

            //Create row and col variables which represent indexes that correspond to a position on our board
            int row = 0;
            int col = 0;

            //Only break out of the while loop once the user enters a valid position
            while (true) {

                //Ask the user for what position they want to place their x or o
                System.out.print("Enter a row number (1, 2 or 3): ");
                row = in.nextInt() - 1;
                System.out.print("Enter a column number (1, 2, or 3): ");
                col = in.nextInt() - 1;

                //Check if the row and col are 0, 1, or 2
                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("This position is off the bounds of the board! Try again.");

                    //Check if the position on the board the user entered is empty (has a -) or not
                } else if (board[row][col] != '-') {
                    System.out.println("Someone has already made a move at this position! Try again.");

                    //Otherwise, the position is valid so break out of the while loop
                } else {
                    break;
                }

            }

            //Set the position on the board at row, col to c
            board[row][col] = c;

            //Check to see if either player has won
            if (somebodyWins(board) == 'x') {
                System.out.println(playerOne + " has won!");
                gameEnded = true;
                playerOneScore++;
            } else if (somebodyWins(board) == 'o') {
                System.out.println(playerTwo + " has won!");
                gameEnded = true;
                playerTwoScore++;
            } else {

                //If neither player has won, check to see if there has been a tie (if the board is full)
                if (boardIsFull(board)) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    //If player1 is true, make it false, and vice versa; this way, the players alternate each turn
                    player1 = !player1;
                }

            }



        }

        //Draw the board at the end of the game
        printBored(board);
        printScores(playerOne,playerOneScore);
        printScores(playerTwo,playerTwoScore);
    altenativeFlag =checkAlternative(altenativeFlag,playerOne,playerTwo);

}//End of while for Alternative
    }//End of main

    private static boolean checkAlternative(boolean flag,String playerNameOne,String playerNametwo) {
        System.out.println(playerNameOne+" and "+playerNametwo +" Do you want to continue?Y/N");
        String flagAnswer;
        Scanner answer = new Scanner(System.in);
         flagAnswer = answer.nextLine();
         flagAnswer=flagAnswer.toLowerCase();
         if(flagAnswer=="y")
             flag=true;
         else if (flagAnswer=="n")
             flag=false;
         return flag;

    }

    private static void printScores(String playerName,int scoreOfPLayer  ) {
        System.out.println(playerName+" Your Score is "+scoreOfPLayer);
        if(scoreOfPLayer==0)
            System.out.println(playerName+" Try harder!");

    }


    public  static void printBored(char[][] board)
    {
        System.out.println("Board Game Now");
        for(int i=0;i<3;i++)
        {
for(int j=0;j<3;j++)
    System.out.print(board[i][j]);
            System.out.println();

        }

    }




    public static boolean boardIsFull(char[][] board)
    {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == '-')
                    return false;

            }
        }
        return true;
    }

    public static char somebodyWins(char[][] board) {

        for(int i = 0; i < 3; i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }

        for(int j = 0; j < 3; j++) {
            if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }

        return ' ';

    }

}//End of class
