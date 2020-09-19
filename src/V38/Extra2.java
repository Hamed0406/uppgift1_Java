package V38;
/*

Skriv ett program som

a. tar in en hexadecimalt tal och sedan skriver ut det som en decimal:

Input Data:
Input a hexadecimal number: 25

Expected Output

Equivalent decimal number is: 37
b. Gör en metod som gör det omvända.

c. Försök kombinera 2 och 3 så vi kan hantera en användares input både om det är decimal  eller decimalt tal.

Refrecne link1 [https://sv.wikipedia.org/wiki/Hexadecimala_talsystemet]
         link2[http://cmc.education/courses/programmering7till9/teori/datorkunskap.php]
*/


import java.util.Scanner;

public class Extra2 {
public static void main(String args[]) {
System.out.print("Please Enter your Hexadecimal number : ");
    Scanner scanner=new Scanner(System.in);
    String inputString=scanner.nextLine();//Get Heximal number from User
    int decimal=Integer.parseInt(inputString,16);
    System.out.println("Decimal value is :" +decimal);
System.out.print("Please enter your Decimal number : ");
int userDecimal=scanner.nextInt();//Get Decimal numbers from user
    String hex=Integer.toHexString(userDecimal);
    System.out.print("Heximcal numer is : "+hex);








}
}
