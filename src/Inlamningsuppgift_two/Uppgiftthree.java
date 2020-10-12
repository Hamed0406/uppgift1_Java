package Inlamningsuppgift_two;
import java.util.Scanner;


public class Uppgiftthree {


    public static void main(String[] args) {
        int rows = 8;
        int rowCount = 1;

        System.out.println("Here Is Your Pyramid");
        //Implementing the logic

        for (int i = rows; i > 0; i--) {
            //Printing i*2 spaces at the beginning of each row
            for (int j = 1; j <= i * 2; j++) {
                System.out.print("   ");
            }

            //Printing j value where j value will be from 1 to rowCount

            for (int j = 0; j <= rowCount - 1; j++) {
                int number = (int) Math.pow(3, j);
                int length = (int) (Math.log10(number) + 1);
                if (length == 1)
                    System.out.print("     "+"\u001B[31m"+number+"\u001B[0m");
                if (length == 2)
                    System.out.print("    " +  "\u001B[33m"+number+"\u001B[0m");
                if (length == 3)
                    System.out.print("   " + "\u001B[36m"+ number+"\u001B[0m");
                if (length == 4)
                    System.out.print("  " +"\u001B[36m"+number+"\u001B[0m");
            }

            //Printing j value where j value will be from rowCount-1 to 1

            for (int j = rowCount - 1; j >= 1; j--) {
                int number = (int) Math.pow(3, j - 1);
                int length = (int) (Math.log10(number) + 1);

                if (length == 1)
                    System.out.print("     " + "\u001B[31m"+number+"\u001B[0m");
                if (length == 2)
                    System.out.print("    " + "\u001B[33m"+number+"\u001B[0m");
                if (length == 3)
                    System.out.print("   " +"\u001B[36m"+ number+"\u001B[0m");
                if (length == 4)
                    System.out.print("  " + number);
            }

            System.out.println();

            //Incrementing the rowCount

            rowCount++;

        }
    }
}

