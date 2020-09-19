package V38;
/*
* Skriv ett program som tar in en Int och som sedan skriver ut summan av siffrorna:

Input Data:
Input an integer: 25
Expected Output

The sum of the digits is: 7
* */

import java.util.Scanner;

public class Extra3 {
    public static  void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Please enter your number : ");
        int inputInt= scanner.nextInt();
        int sum=0;
        int tempSum;
        while(inputInt>0){
         tempSum=inputInt%10;
         inputInt=inputInt/10;
         sum=sum+tempSum;
        }
 System.out.print("Sum of digits are : "+sum);

    }
}
