package repeatkorsen;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/*1- Läs in en siffra från en användare, skriv sedan ut den.
2- Läs in två siffror, addera dessa och skriv sedan ut resultatet
3-Gör ett program som kan dividera två tal men också ta ut restvärde och sedan skriv ut det.
4-Gör ett program som kan dividera två tal men också ta ut restvärde och sedan skriv ut det.
5- Gör ett program som kan skriva ut värdet av ett tecken (char).
6- Gör ett program som kan kolla om ett tal är jämnt eller udda med hjälp av en if-sats.
7-Gör uppgift 6 fast med en ternary operator. ? :
8-Gör ett program som kan kolla om ett tecken är en vokal eller konsonant med en if-sats.
9- Bryt ut logiken i uppgift 8 till en metod.
10-Skapa en ytterligare metod som gör samma sak fast med en switch-sats.

14-
15  Gör ett program som kan ta ut det största talet i en array.
16-Gör ett program som kan sätta ihop två arrayer till en array, oavsett storlek på arrayerna.
17-17. Gör uppgift 16, men som sparar resulterande array till en .txt-fil.

 *
*
* */
public class Repeatkorsen {
    public static void main(String args[]){



        int lenthOfFirstArraye,lenthOfSecoundArraye;
        int firstArraye[],secoundArraye[];
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter lenth of first arraye");
        lenthOfFirstArraye=sc.nextInt();
        firstArraye=new int[lenthOfFirstArraye];
        arrayeFiller(firstArraye,lenthOfFirstArraye);
        System.out.println("Please enter lenth of second arraye arraye");
        lenthOfSecoundArraye=sc.nextInt();
        secoundArraye=new int[lenthOfSecoundArraye];
        arrayeFiller(secoundArraye,lenthOfSecoundArraye);
        int lengthOfJointArray=lenthOfFirstArraye+lenthOfSecoundArraye;
        int jointArraye[];
        jointArraye=new int[lengthOfJointArray];
        printArraye(firstArraye,lenthOfFirstArraye);
        System.out.println();
        printArraye(secoundArraye,lenthOfSecoundArraye);
        System.out.println();

        for(int i=0;i<lenthOfFirstArraye;i++)
        {
            jointArraye[i]=firstArraye[i];
        }
        int secoundJointCounter=lenthOfFirstArraye--;
        for(int j=0;j<lenthOfSecoundArraye;j++)
        {
            jointArraye[secoundJointCounter]=secoundArraye[j];
            secoundJointCounter++;
        }
        printArraye(jointArraye,lengthOfJointArray);
        //Create file txt
try {
    File fileObject=new File("jointArray.txt");
    if(fileObject.createNewFile())
    {
        System.out.println("File is created ");
    }
    else
        System.out.println("File is already exist ");
}
catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
//Write to the file
        try {
            FileWriter fileWriter=new FileWriter("jointArray.txt");
            for(int z=0;z<lengthOfJointArray;z++)
            {
fileWriter.write(jointArraye[z] + "\t");
            }
            fileWriter.close();

        }
        catch(IOException e)
        {

            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }//End of main
    public static void ex1()
    {
        int input;
        Scanner sc=new Scanner(System.in);
        input= sc.nextInt();
        System.out.println("Your input was "+input);
    }

    public static void ex2()
    {

        int digit1,digit2;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter first digits:");
        digit1= sc.nextInt();
        System.out.println("Please enter second digits:");
        digit2=sc.nextInt();
        int sum=digit1+digit2;
        System.out.println("Added amount is :" +sum);
    }
    public static void ex3()
    {
        float digit1,digit2;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter first digits:");
        digit1= sc.nextFloat();
        System.out.println("Please enter second digits:");
        digit2=sc.nextFloat();
        float sum=digit1+digit2;
        System.out.println("Added amount is :" +sum);
    }

    public static void ex4()
    {
        float digit1,digit2;
        float restvarde,divide;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter first digit :");
        digit1=sc.nextInt();
        System.out.println("Your input was : "+ digit1);
        System.out.println("Please enter second digit :");
        digit2=sc.nextInt();
        System.out.println("Your input was : "+ digit2);
        divide=digit1/digit2;
        restvarde=digit1%digit2;
        System.out.println("divided input was : "+ divide);
        System.out.println("restvarde input was : "+ restvarde);
    }

    public  static void ex5()
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your Char" );
        String a = sc.next();
        int valueOfChar=a.charAt(0);
        System.out.println("The value of Char is "+valueOfChar );

    }

    public static void ex6()
    {
        int a;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your number : ");
        a= sc.nextInt();
        if(a%2==0) {
            System.out.println("Your number was jamt ");
        }
        else
            System.out.println("Your number was add ");

    }

    public static void ex7()
    {
        int a;
        String result;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your number : ");
        a=sc.nextInt();
        result=(a%2==0)?"even":"add";
        System.out.println("Your number was "+result);
    }

    public static void ex8()
    {
        String s;
        int i=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter your character : ");
        s=sc.next();

        if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'||s.charAt(i)=='y'||s.charAt(i)=='å'||s.charAt(i)=='ä'||s.charAt(i)=='ö'){
            System.out.println("The character was vocal");
        }
        else
            System.out.println("The character was constenet");
    }
    public static void ex9(char a)
    {
        if(a == 'a' ||a == 'e' || a == 'i' || a == 'o' || a == 'u'||a=='y'||a=='å'||a=='ä'||a=='ö'){
            System.out.println("The character was vocal");
        }
        else
            System.out.println("The character was constenet");
    }

    public static void ex10(char a)
    {
        switch (a)
        {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
            case'å':
            case 'ä':
            case 'ö':
                System.out.println("The character was vocal");
break;
            default:
                System.out.println("The character was constenet");



        }//End of switch

    }

    public static void ex14(){
    int counterFizzBuzz=0,numberCounter=1;
    String three="fizz",five="buzz",threeFive="fizzbuzz";
       while(counterFizzBuzz<=100)
    {
        if(numberCounter%3==0&&numberCounter%5==0)
        { System.out.print(" "+threeFive+" ");
            counterFizzBuzz++;}
        else if(numberCounter%3==0)
        {System.out.print(" "+three+" ");}
        else if(numberCounter%5==0)
        {System.out.print(" "+five+" ");}
        else if(numberCounter%3!=0&&numberCounter%5!=0)
        {System.out.print(" "+numberCounter+" ");}
        numberCounter++;
    }//End of while
    }
public static int myRandom()
{
    int max=1000;
    int min=0;
    Random r=new Random();
    int randomNumber=r.nextInt((max - min) + 1) + min;
    return randomNumber;
}

public static void ex15()
{
    int myArraye[];
    myArraye=new int[100];
    for(int i=0;i<100;i++)
    {
        myArraye[i]=myRandom();
    }//create Test Arraye  with 100 int number .
    int maxNumber=myArraye[0];//We consider first element is biggest one until we find apposite .
    for(int j=0;j<100;j++)
    {
        if(myArraye[j]>maxNumber)
            maxNumber=myArraye[j];

    }
    System.out.print(maxNumber);
}
public static void arrayeFiller(int myArray[],int lenth)
{
    for(int i=0;i<lenth;i++)
    {
        myArray[i]=myRandom();
    }
}
public static void printArraye(int myArr[],int lenth)
{
    for(int i=0;i<lenth;i++)
        System.out.print(" "+myArr[i]+" ");
}

public static void ex16()
{
    int lenthOfFirstArraye,lenthOfSecoundArraye;
    int firstArraye[],secoundArraye[];
    Scanner sc=new Scanner(System.in);
    System.out.println("Please enter lenth of first arraye");
    lenthOfFirstArraye=sc.nextInt();
    firstArraye=new int[lenthOfFirstArraye];
    arrayeFiller(firstArraye,lenthOfFirstArraye);
    System.out.println("Please enter lenth of second arraye arraye");
    lenthOfSecoundArraye=sc.nextInt();
    secoundArraye=new int[lenthOfSecoundArraye];
    arrayeFiller(secoundArraye,lenthOfSecoundArraye);
    int lengthOfJointArray=lenthOfFirstArraye+lenthOfSecoundArraye;
    int jointArraye[];
    jointArraye=new int[lengthOfJointArray];
    printArraye(firstArraye,lenthOfFirstArraye);
    System.out.println();
    printArraye(secoundArraye,lenthOfSecoundArraye);
    System.out.println();

    for(int i=0;i<lenthOfFirstArraye;i++)
    {
        jointArraye[i]=firstArraye[i];
    }
    int secoundJointCounter=lenthOfFirstArraye--;
    for(int j=0;j<lenthOfSecoundArraye;j++)
    {
        jointArraye[secoundJointCounter]=secoundArraye[j];
        secoundJointCounter++;
    }
    printArraye(jointArraye,lengthOfJointArray);
    //Create file txt

}
}//End of claas
