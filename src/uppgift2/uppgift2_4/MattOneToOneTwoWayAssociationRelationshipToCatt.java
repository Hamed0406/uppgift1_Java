package uppgift2.uppgift2_4;

public class MattOneToOneTwoWayAssociationRelationshipToCatt {
    String mamaOwnerName;
    CatOneToOneTwoWayAssociationRelationshipToMatte catOneToOneTwoWayAssociationRelationshipToMatte;

    public MattOneToOneTwoWayAssociationRelationshipToCatt(String mamaOwnerName, CatOneToOneTwoWayAssociationRelationshipToMatte catOneToOneTwoWayAssociationRelationshipToMatte) {
        this.mamaOwnerName = mamaOwnerName;
        this.catOneToOneTwoWayAssociationRelationshipToMatte = catOneToOneTwoWayAssociationRelationshipToMatte;
    }

    public String getMamaOwnerName() {
        return mamaOwnerName;
    }

    public CatOneToOneTwoWayAssociationRelationshipToMatte getCatOneToOneTwoWayAssociationRelationshipToMatte() {
        return catOneToOneTwoWayAssociationRelationshipToMatte;
    }

    @Override
    public String toString() {
        return "MattOneToOneTwoWayAssociationRelationshipToCatt{" +
                "mamaOwnerName='" + mamaOwnerName + '\'' +
                ", catOneToOneTwoWayAssociationRelationshipToMatte=" + catOneToOneTwoWayAssociationRelationshipToMatte +
                '}';
    }
}
