package uppgift2.uppgift2_1;

public class TestMainUppgift2_1 {
    public static void main(String[] args) {

        /*  •	Demonstrera klasserna med en Main klass som skapar hundar och katter och skriver ut deras namn och ras  */
        Dog testDog = new Dog("Lilly", "boldag");//Create Dog object with constructor.
        CatOneToOneAssociationRelationshipToMatte testCatt = new CatOneToOneAssociationRelationshipToMatte("Simba", "BonneKatt");//Create cat object with contracture .
        System.out.println("Test Dog name is: " + testDog.getDogName() + "\nTest Dog race is : " + testDog.getDogRace());
        System.out.println("Test cat name is: " + testCatt.getCattName() + "\nTest cat race is : " + testCatt.getCatRace());


    }
}