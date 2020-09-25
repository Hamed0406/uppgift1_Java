package Inlalmingupgift;

import java.util.Scanner;

public class Exthree {
    public static void main(String args[])
    {
        System.out.println("Hello i am here to help you to calculate how much energy you consume for boiling water for your tea.");
        System.out.println("First ,Please enter how much water would like to boil ? You can enter digits with two decimal");
        System.out.print("Please enter M : ");
        Scanner sc=new Scanner(System.in);
        float m=sc.nextFloat();
        System.out.println("Thank you for your input, Please Enter How cold is water which would you like to boil? You can enter digits with two decimal");
        System.out.print("Please enter Starttemperatur : ");
        float starttemperatur=sc.nextFloat();
        System.out.println("Thank you for your input, Please Enter How warm do you want to boil the water? You can enter digits with two decimal");
        System.out.print("Please enter Sluttemperatur : ");
        float sluttemperatur=sc.nextFloat();
        System.out.println("Thank you!");
        System.out.print("You entered  :" +m+  " as M ," +starttemperatur+ " as Starttemperatur,  " +sluttemperatur+ " as Sluttemperatur.");
double q=m*(sluttemperatur-starttemperatur)*4184;
double kq=q/1000;
System.out.println("You will consume : "+q+ " j energy or " +kq+ " kj energy.");


    }
}
