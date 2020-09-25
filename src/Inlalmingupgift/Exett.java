package Inlalmingupgift;

import java.util.Scanner;

import static java.lang.System.exit;

/*
  Uppgift 1
Ett skottår har 366 dagar och februari det året har 29 dagar. För att kontrollera om ett år är ett skottår kan du kolla om året är delbart med 4, men inte med 100 eller 400.
User story
Som användare vill jag kunna mata in ett årtal och få respons från programmet om det inmatade årtalet är ett skottår.
* */
public class Exett {

    public static void main(String[] args){
     //   int inputYear;
        System.out.println("Please enter any year you like ?");
        Scanner sc=new Scanner(System.in);
        int inputYear= sc.nextInt();// User input has 4 digits .
        if(inputYear%4==0){
            if(inputYear%100==0){
                if(inputYear%400==0)
                    System.out.println("The entered year is a Leap year");
                else
                    System.out.println("The entered year is not Leap year");

            }
            else
            {
                System.out.println("The entered year is a Leap year");
           // exit(0);
            }

        }
else System.out.println("The entered year is not Leap year");
    }
}

