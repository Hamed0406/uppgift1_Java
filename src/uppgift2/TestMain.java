package uppgift2;

import java.util.ArrayList;

public class TestMain {
    public static void main(String [] args)
    {

        /*  •	Demonstrera klasserna med en Main klass som skapar hundar och katter och skriver ut deras namn och ras  */
Dog testDog=new Dog("Lilly","boldag");//Create Dog object with constructor.
        Cat testCatt=new Cat("Simba","BonneKatt");//Create cat object with contracture .
System.out.println("Test Dog name is: "+testDog.getDogName()+"\nTest Dog race is : "+testDog.getDogRace());
        System.out.println("Test cat name is: "+testCatt.getCattName()+"\nTest cat race is : "+testCatt.getCatRace());


        /*EN to EN demonstration */
        Matte testMatte=new Matte("Petra",testCatt);//Send object cat to the constructor .
        System.out.println("Cat owner name is : "+testMatte.getMamaOwnerName()+"\n Name of cat is : "+testMatte.getCatAsPet().getCattName()+"\n Cat race is : "+testMatte.getCatAsPet().getCatRace());
/*( En -> Många ) demonstration */
        ArrayList<Dog> testDogArrayList=new ArrayList<Dog>();
        testDogArrayList.add(testDog);

        Husse testHusse=new Husse("Hamed",testDogArrayList);
        Dog testDog1,testDog2;
        testDog1 = new Dog("Wolfy","GermanShaper");//set name and race by conductor for test1 .
        testDog2=new Dog("Sgorty","Husky");//set name and race by conductor for test2 .

        testDogArrayList.add(testDog1);//Add to the list
        testDogArrayList.add(testDog2);//Add to the list

        testHusse.printDogOwnerNameAndDogs();




    }//end of main
}//End of class TestMain
