package Inlamningsuppgift_two;
/*
*
Svenska språket har följande vokaler:

        a, e, i, o, u, y, å, ä och ö

        Samt följande konsonanter:

        b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, z och x

        User story
        Som användare vill jag kunna mata in en mening i ett program, och få presenterat för mig hur många vokaler respektive konsonanter som min mening innehåller. */

import java.util.Scanner;

public class Uppgift_ett {
    public static void main(String arg[]){
        final String TEXT_YELLOW = "\u001B[33m";
        final String TEXT_RESET = "\u001B[0m";
        final String TEXT_BLUE = "\u001B[34m";
        final String TEXT_BOLD ="\u001B[1m";

       // Scanner sc=new Scanner(System.in, "Cp850");
        int stringLenth;
        boolean flag=true;
        System.out.println("Pleas enter your sentence. I will count for you hom many vowels and consonants exist in your sentence.Also we count how many digits you have in your sentence.  ");
//I also count digits , due to if user enter just digits as input a program can response.otherwise it just wait for user to enter new string with alphabet.

        do
       {
           String s = new Scanner(System.in).nextLine();

           stringLenth=s.length();
           s.toLowerCase();//convert all character to lowercase for simplifying .
           int vokalar=0,konsonanter=0,digit=0;
           for(int i=0;i<stringLenth;i++)
           {
               if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'||s.charAt(i)=='y'||s.charAt(i)=='å'||s.charAt(i)=='ä'||s.charAt(i)=='ö'){vokalar++;}
               else if((s.charAt(i) >= 'a' && s.charAt(i)<='z')){konsonanter++;}
               if (Character.isDigit(s.charAt(i))){digit++;}
           }
           System.out.println( "the sentence you had been entered has "  +TEXT_YELLOW +vokalar+ TEXT_RESET+TEXT_BOLD+" Vowels." );
           System.out.println( "the sentence you had been entered has "+TEXT_BLUE+konsonanter +TEXT_RESET+TEXT_BOLD+" Consonants." );
           System.out.println( "the sentence you had been entered has "+TEXT_BLUE+digit +TEXT_RESET+TEXT_BOLD+" Digits." );
           System.out.println("Do you want to enter a new sentence?Y/N.");
           Scanner scanner=new Scanner(System.in);
           String answer=scanner.next();
           answer.toLowerCase();
           if(answer.equals("y")) {
               flag = true;
               System.out.println("Pleas enter your sentence. I will count for you hom many vowels and consonants exist in your sentence. ");
           }
           else if(answer.equals("n")) {
               flag = false;
               System.out.println("Have good day ! ");
           }
       }
       while(flag) ;




    }
}
