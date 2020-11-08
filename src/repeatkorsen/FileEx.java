package repeatkorsen;

import java.io.*;
import java.util.Scanner;

public class FileEx {
    public static void main(String Args[]) {
        try {
            //creat a file
            File myFileobj = new File("TestFilewithWrting.txt");
            if(myFileobj.createNewFile())
            {
                System.out.println("File is created ");
            }
            else
                System.out.println("File is already exist ");
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //read write
        try{
            FileWriter myFileWriter=new FileWriter("TestFilewithWrting.txt");
            myFileWriter.write("Oj this is my first Java filr i wrote in\nTHis is secound lune\nthirsline  ");
            myFileWriter.close();
            System.out.println("It had been wroten sucessfuly and it had been close ");
        }
        catch (IOException e)
        {
            System.out.println("We have error");
            e.printStackTrace();
        }
        //Read from file
        try
        {
            File myFileReader=new File("TestFilewithWrting.txt");
            Scanner sc=new Scanner(myFileReader);
while(sc.hasNextLine())
{
    String dataOutput=sc.nextLine();
    System.out.println(dataOutput);
}
sc.close();
        }
        catch(IOException e)
        {
            System.out.println("It has error in Reading");
            e.printStackTrace();
        }
    }//End of main
}//End of Class