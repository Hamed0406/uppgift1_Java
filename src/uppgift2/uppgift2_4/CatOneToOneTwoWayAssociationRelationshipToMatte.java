package uppgift2.uppgift2_4;


public class CatOneToOneTwoWayAssociationRelationshipToMatte {
    private String cattName;
    private String catRace;
    private MattOneToOneTwoWayAssociationRelationshipToCatt mattOneToOneTwoWayAssociationRelationshipToCattForGettingName;

    public CatOneToOneTwoWayAssociationRelationshipToMatte(String cattName, String catRace) {
        this.cattName = cattName;
        this.catRace = catRace;
    }

    public String getCattName() {
        return cattName;
    }

    public void setCattName(String cattName) {
        this.cattName = cattName;
    }

    public String getCatRace() {
        return catRace;
    }

    public void setCatRace(String catRace) {
        this.catRace = catRace;
    }

    public String getMattename(MattOneToOneTwoWayAssociationRelationshipToCatt mattOneToOneTwoWayAssociationRelationshipToCattForGettingName) {

        return mattOneToOneTwoWayAssociationRelationshipToCattForGettingName.getMamaOwnerName();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "cattName='" + cattName + '\'' +
                ", catRace='" + catRace + '\'' +
                '}';
    }
}
