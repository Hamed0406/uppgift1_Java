package W28;

import java.util.Scanner;

//Skriv ett program som tar in 3 tal och som skriver ut medelvärdet.
public class Extra1 {
    public static void main(String args[] )
    {
        System.out.println("Please enter three numbers for calculate the averages ");
    System.out.print("Please enter the first number:");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.print("Please enter second number: ");
        int b=sc.nextInt();
        System.out.print("Please enter third number:");
        int c=sc.nextInt();
int d=a+b+c;
d=d/3;
System.out.print("Your average is : ");
System.out.print(d);
    }
}
