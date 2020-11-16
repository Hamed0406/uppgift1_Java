package uppgift2;

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
        System.out.println("Cat owner name is : "+testMatte.getMamaOwnerName()+" Name of cat is : "+testMatte.getCatAsPet().getCattName()+" Cat race is : "+testMatte.getCatAsPet().getCatRace());



    }//end of main
}//End of class TestMain
