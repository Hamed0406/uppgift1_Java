//package Inlaminguppgift_Three; Remove pakage name in old assignment

import java.util.Random;
import java.util.Scanner;
/*
* It has simple logic : i have a 3*3 array which can fill with X,O and " - " characters.
* I considered two alternative play mod : two players (User vs User) and one player mod an User Vs a Computer.
*
* */
public class Tictactoe {

    public  static void main(String args[])
    {
        
        int playerOneScore=0,playerTwoScore=0;
        boolean alternativeFlagToContinue=false;//for choice if they want to continue
        boolean alternativeFlagForPlayMood=false;//Default mood is 2 player
        char[][] board = new char[3][3]; // It has three alternative : X for PLayer one . O for player two . " - "  for empty place.

        
        
        Scanner in = new Scanner(System.in);
        System.out.println("Welcomed to Tic Tac toe! Do you want to play vs Computer or do you want to play player vs player ?Y Vs computer and N player vs player");
String playMoodAlternative=in.nextLine();
playMoodAlternative=playMoodAlternative.toLowerCase();
if(playMoodAlternative.equals("y"))
    alternativeFlagForPlayMood=true;
if(alternativeFlagForPlayMood)
{
    System.out.println("Wholesome to Tic Tac Toe! You know the rolls lets Start with your name ");
    System.out.print(" what is your name? ");
    String playerOne = in.nextLine();
    System.out.println("Welcomed to the game " + playerOne);
    System.out.print("Pick a name for Computer ");
    String playerTwo = in.nextLine();
    System.out.println( playerTwo+" is ready to play");


    while (!alternativeFlagToContinue) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }//Print the board.


        boolean playerOneFlag = true;

        boolean gameEnded = false;
        while (!gameEnded)
        {

            //print the board
            printBored(board);

            if (playerOneFlag) {
                System.out.println(playerOne + "'s Turn (x):");
            } else {
                System.out.println(playerTwo + "'s Turn (o):");
            }

            char c = '-';
            if (playerOneFlag) {
                c = 'x';
            } else {
                c = 'o';
            }

            int row = 0;
            int col = 0;

            while (true)// It always true until somebody enter right passion

            {
if(playerOneFlag){
                System.out.print("Enter a row number (1, 2 or 3): ");
                row = in.nextInt() - 1;
                System.out.print("Enter a column number (1, 2, or 3): ");
                col = in.nextInt() - 1;
    //Check if the row and col are 0, 1, or 2
    if (row < 0 || col < 0 || row > 2 || col > 2) {
        System.out.println("This position is off the bounds of the board! Try again.");

    } else if (board[row][col] != '-') {
        System.out.println("Someone has already made a move at this position! Try again.");

    } else {
        break;
    }

}
else
{

    row=computerPick()-1;
    col=computerPick()-1;
    //TO DO check position

    if (board[row][col] != '-')//To check if the coordinate already had been taken .
    {
        //new coordinate
        row=computerPick()-1;
        col=computerPick()-1;

    }
    else
        break;
}


            }

            board[row][col] = c; //Fill the borard.

            if (somebodyWins(board) == 'x') {
                System.out.println(playerOne + " has won!");
                gameEnded = true;
                playerOneScore++;
            } else if (somebodyWins(board) == 'o') {
                System.out.println(playerTwo + " has won!");
                gameEnded = true;
                playerTwoScore++;
            } else {

                if (boardIsFull(board)) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    playerOneFlag = !playerOneFlag;
                }

            }


        }

        // Draw the board at the end of the game

        printBored(board);
        printScores(playerOne, playerOneScore);
        printScores(playerTwo, playerTwoScore);
        alternativeFlagToContinue = checkAlternative(playerOne, playerTwo);
    }//End of while for Alternative





}//End of if with Computer


if(!alternativeFlagForPlayMood) {
    System.out.println("Wholesome to Tic Tac Toe! You know the rolls lets Start with your name ");
    System.out.print("Player 1, what is your name? ");
    String playerOne = in.nextLine();
    System.out.println("Welcomed to the game " + playerOne);
    System.out.print("Player 2, what is your name? ");
    String playerTwo = in.nextLine();
    System.out.println("Welcomed to the game " + playerTwo);
    while (!alternativeFlagToContinue) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }


        boolean player1 = true;

        boolean gameEnded = false;
        while (!gameEnded) {

            printBored(board);

            if (player1) {
                System.out.println(playerOne + "'s Turn (x):");
            } else {
                System.out.println(playerTwo + "'s Turn (o):");
            }

            char c = '-';
            if (player1)
            {
                c = 'x';
            } else {
                c = 'o';
            }

            int row = 0;
            int col = 0;

            while (true) // It always true until somebody enter right passion
                {

                System.out.print("Enter a row number (1, 2 or 3): ");
                row = in.nextInt() - 1;
                System.out.print("Enter a column number (1, 2, or 3): ");
                col = in.nextInt() - 1;

                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("This position is off the bounds of the board! Try again.");

                } else if (board[row][col] != '-') {
                    System.out.println("Someone has already made a move at this position! Try again.");

                } else {
                    break;
                }

            }

            board[row][col] = c;

            //Check to see if anybody wined.
            if (somebodyWins(board) == 'x') {
                System.out.println(playerOne + " has won!");
                gameEnded = true;
                playerOneScore++;
            } else if (somebodyWins(board) == 'o') {
                System.out.println(playerTwo + " has won!");
                gameEnded = true;
                playerTwoScore++;
            } else {

                if (boardIsFull(board)) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    player1 = !player1;
                }

            }


        }

        // Draw the board at the end of the game

        printBored(board);
        printScores(playerOne, playerOneScore);
        printScores(playerTwo, playerTwoScore);
        alternativeFlagToContinue = checkAlternative(playerOne, playerTwo);
    }//End of while for Alternative Continue 2 Player.

}
    }//End of main

    public static boolean checkAlternative(String playerNameOne, String playerNametwo) {
        //To check if user want to play again.
        System.out.println(playerNameOne+" and "+playerNametwo +" Do you want to continue?Y/N");
        String flagAnswer;
        boolean flagA=true;
        Scanner answer = new Scanner(System.in);
         flagAnswer = answer.nextLine();
         flagAnswer=flagAnswer.toLowerCase();
         if(flagAnswer.equals("y"))
             flagA=false;
         if (flagAnswer.equals("n"))
             flagA=true;
      //  boolean flag = flagA;
         return flagA;

    }

    public static void printScores(String playerName,int scoreOfPLayer  ) {

        //Print score of player.
        System.out.println(playerName+" Your Score is "+scoreOfPLayer);
        if(scoreOfPLayer==0)
            System.out.println(playerName+" Try harder!");

    }


    public  static void printBored(char[][] board)
    {
        System.out.println("Board Game");
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
//logic part , check every possibility for winning.
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

    public  static int computerPick()
    {
        //Produce ransom number between 1-3
        int pcPick;
        int min=1,max=3;
        Random r = new Random();
        pcPick= r.nextInt((max - min) + 1) + min;
        return  pcPick;
    }



}//End of class
