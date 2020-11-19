package uppgift2.uppgift2_2;

import uppgift2.uppgift2_1.CatOneToOneAssociationRelationshipToMatte;

/*
* One to One associationer ( En - > En )
Definiera en klass Matte med en konstruktor som tar Mattes namn, samt en Katt. (Som objekt) Klassen skall ha operationer för att returnera Mattes namn samt katt-objektet.
•	Rita UML-diagram för Matte- och Katt-klasserna
•	Demonstrera klasserna med en Main klass.
*/
public class Matte {
    String mamaOwnerName;
    CatOneToOneAssociationRelationshipToMatte catOneToOneRelationshipToMatteAsPet;

    public Matte(String mamaOwnerName, CatOneToOneAssociationRelationshipToMatte catOneToOneRelationshipToMatteAsPet) {
        this.mamaOwnerName = mamaOwnerName;
        this.catOneToOneRelationshipToMatteAsPet = catOneToOneRelationshipToMatteAsPet;
    }

    public String getMamaOwnerName() {
        return mamaOwnerName;
    }

    public void setMamaOwnerName(String mamaOwnerName) {
        this.mamaOwnerName = mamaOwnerName;
    }

    public CatOneToOneAssociationRelationshipToMatte getCatAsPet() {
        return catOneToOneRelationshipToMatteAsPet;
    }

    @Override
    public String toString() {
        return "Matte{" +
                "mamaOwnerName='" + mamaOwnerName + '\'' +
                ", catAsPet=" + catOneToOneRelationshipToMatteAsPet +
                '}';
    }
}//End of Matt Class
