package Inlamningsuppgift_two;

public class testtwo {
    public static void main(String[] args) {
        int x =8;
        int rowCount = 1;

        System.out.println("Here Is Your Pyramid");
        //Implementing the logic

        for (int i = x; i > 0; i--)
        {
            //Printing i*2 spaces at the beginning of each row
            for (int j = 1; j <= i*2; j++)
            {
                System.out.print("   ");
            }

            //Printing j value where j value will be from 1 to rowCount

            for (int j = 0; j <= rowCount-1; j++)
            {
                int number = (int) Math.pow(3, j);
                int length = (int) (Math.log10(number) + 1);

                if (length == 1)
                    System.out.print("     "+ number);
                if (length == 2)
                    System.out.print("    "+ number);
                if (length == 3)
                    System.out.print("   "+number );
                if (length == 4)
                    System.out.print("  "+ number);
              //  System.out.printf("%3d", (int)Math.pow(3, j));
            }

            //Printing j value where j value will be from rowCount-1 to 1

            for (int j = rowCount-1; j >= 1; j--)
            {
                int number = (int) Math.pow(3, j-1);
                int length = (int) (Math.log10(number) + 1);

                if (length == 1)
                    System.out.print( "     "+number);
                if (length == 2)
                    System.out.print("    "+ number);
                if (length == 3)
                    System.out.print("   " +number);
                if (length == 4)
                    System.out.print( "  "+number);
              //  System.out.printf("%3d", (int)Math.pow(3, j-1));
            }

            System.out.println();

            //Incrementing the rowCount

            rowCount++;

        }
    }
}
