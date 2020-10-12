package Inlamningsuppgift_two;

public class Test {
    public static void main(String[] args) {
        int row = 8, caloum = (row*2)-1;
        int length=0;
        int number=0;
        int counter=row;


        for (int i = 1; i <= row; i++) {

            for(int k=1;k<=caloum-counter;k++)

                System.out.print(" ");//ok


            for (int j = 1; j <=(i*2)-1; j++)//ok inner conter
            {
        //    System.out.print(j);
            //to do
             /*   while(counter!= 2*i-1)
                {
                    System.out.print("1");
                }*/

               number = (int) Math.pow(3, (i-1) - j+1);
                length = (int) (Math.log10(number) + 1);

                    if (length == 1)
                        System.out.print("     " + number);
                    if (length == 2)
                        System.out.print("    " + number);
                    if (length == 3)
                        System.out.print("   " + number);
                    if (length == 4)
                        System.out.print("  " + number);


            }
            counter++;
        System.out.println();
        }
    }
}
