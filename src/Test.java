
import java.util.Random;
import java.util.*;



public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //Uppgift #1
        System.out.println("Hejsvejs");
        System.out.println("Hejsvejs");


        //Uppgift #2
        int counter=10; //Counter
        while(counter>=0)
        {
            System.out.println(counter);
            counter--;
        }
        //Uppgift #3
        int number_of_teeth_cleaned = 0; //start loop
        System.out.println("put toothpaste on toothbrush");
        while(number_of_teeth_cleaned<=32) {
            number_of_teeth_cleaned++;
            System.out.print("Teeth number#");
            System.out.print(number_of_teeth_cleaned);
            System.out.println("had been clneaned ");
        }
        System.out.println("Total 32 teeth had been cleaned");
        System.out.println(" Toothbrush had been rinsed");

        //Uppgift #4
        int picked_number_by_pc;
        Random picked_number = new Random();

        picked_number_by_pc=picked_number.ints(1, (100 + 1)).limit(1).findFirst().getAsInt();
        for(int i=0;i<3;i++) {
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter your number ");
            int a= sc.nextInt();//User number
            if(a==picked_number_by_pc)
            {
                System.out.println("Bra Jobbat");
                break ;
            }
            else

                System.out.println("Du är dum!");
            if(i==2)
            {
                System.out.print("Right number was #");
                System.out.println(picked_number_by_pc);

            }


        }

///
    }

}
