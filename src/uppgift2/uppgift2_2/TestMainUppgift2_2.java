package uppgift2.uppgift2_2;


import uppgift2.uppgift2_1.CatOneToOneAssociationRelationshipToMatte;

public class TestMainUppgift2_2 {
    public static void main(String[] args) {
        CatOneToOneAssociationRelationshipToMatte testCatt = new CatOneToOneAssociationRelationshipToMatte("Simba", "BonneKatt");//Create cat object with contracture .

        Matte testMatte = new Matte("Petra", testCatt);//Send object cat to the constructor .
        System.out.println("Cat owner name is : " + testMatte.getMamaOwnerName() + "\n Name of cat is : " + testMatte.getCatAsPet().getCattName() + "\n Cat race is : " + testMatte.getCatAsPet().getCatRace());
    }
}

