package uppgift2.uppgift2_4;

public class TestMainUppgift2_4 {
    public static void main(String[] args) {
        CatOneToOneTwoWayAssociationRelationshipToMatte testCatt=new CatOneToOneTwoWayAssociationRelationshipToMatte("Sir Alec","Turkish Abin");
        System.out.println(testCatt.getCattName());
        MattOneToOneTwoWayAssociationRelationshipToCatt testMatt=new MattOneToOneTwoWayAssociationRelationshipToCatt("Elisaeth",testCatt);
       System.out.println("Cat name is "+testCatt.getCattName()+"Owner name is "+testCatt.getMattename(testMatt));
    }
    }
