package Inlamningsuppgift_two;

import java.util.Random;
import java.util.Scanner;

/*
* Ett lottoprogram slumpar fram ett tvåsiffrigt tal mellan 01 och 99. Om användare gissar rätt nummer i rätt ordning, vinner användaren 10 000 kr. Om användaren gissar rätt nummer, men i fel ordning, vinner användaren 5 000 kr. Om användare gissar ett rätt nummer av de två, vinner användaren 1 000 kr.

User story
Som lottospelare vill jag kunna mata in ett tvåsiffrigt nummer i ett program och få besked om jag har gissat rätt och hur mycket jag har vunnit.*/
public class Uppgifttwo {

    public static void main(String args[]) {
        final String TEXT_YELLOW = "\u001B[33m";
        final String TEXT_RESET = "\u001B[0m";
        final String TEXT_BLUE = "\u001B[34m";
        final String TEXT_BOLD = "\u001B[1m";
        final String TEXT_RED = "\u001B[31m";
        int max = 99;
        int min = 1;
        int winNumber, userInput;
        int prize = 0, bank = 0;
        boolean flag = true;
        String winNumberString, userInputString;


        System.out.print("Hi welcome to lottery program.This is first time you are using the system you get one free ticket \nyou pick two a digits number.\nIf you guess right digits in right order ;you win 1000SEK .\nIf you guess right digits ,but not in right order ;you win 5000 SEK.\n if you guess one right digits ; you win 1000 SEK . ");
        System.out.print("If you you are ready to play enter your two digits without any space. ");
        do {
            Random r = new Random();
            winNumber = r.nextInt((max - min) + 1) + min;
            System.out.println(winNumber);

            Scanner sc = new Scanner(System.in);
            userInput = sc.nextInt();
            //control user input  and random number ,converted them in correct order.
            if (winNumber > 0 && winNumber <= 9)
                winNumberString = String.format("%02d", winNumber);
            else
                winNumberString = Integer.toString(winNumber);
            if (userInput > 0 && userInput <= 9)
                userInputString = String.format("%02d", userInput);
            else
                userInputString = Integer.toString(userInput);
            if (winNumberString.equals(userInputString)) {
                prize = 10000;
                System.out.println(" Matched lott .You wined " + prize + " SEK");
                System.out.println(" You have " + bank + " SEK do you want to continueY/N?");

                bank = bank + prize;
            } else if ((winNumberString.charAt(0) == userInputString.charAt(1)) && (winNumberString.charAt(1) == userInputString.charAt(0))) {
                prize = 5000;
                System.out.println(" Mirror lott .You wined " + prize + " SEK");
                bank = bank + prize;

                System.out.println(" You have " + bank + " SEK in your bank do you want to continueY/N?");


            } else if ((userInputString.charAt(0) == winNumberString.charAt(0)) || (userInputString.charAt(0) == winNumberString.charAt(1)) || (userInputString.charAt(1) == winNumberString.charAt(0)) || (userInputString.charAt(1) == winNumberString.charAt(1))) {
                prize = 1000;
                System.out.println(" half lott .You wined " + prize + " SEK");
                bank = bank + prize;

                System.out.println(" You have " + bank + " SEK in your bank do you want to continueY/N?");


            } else if ((userInputString.charAt(0) != winNumberString.charAt(0)) && (userInputString.charAt(0) != winNumberString.charAt(1)) && (userInputString.charAt(1) != winNumberString.charAt(0)) && (userInputString.charAt(1) != winNumberString.charAt(1))) {
                System.out.println("you lost");
                bank = bank + prize;

                System.out.println(" You have " + bank + " SEK in your bank do you want to continueY/N?");

            }

            //check user alternative.
          flag=  check(flag);

        }
        while (flag);


        //  System.out.println(prize);


    }

    private static boolean check(boolean flag) {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        answer.toLowerCase();
        if (answer.equals("y"))
            flag = true;

        else if (answer.equals("n"))
            flag = false;

        return flag;
    }


}
