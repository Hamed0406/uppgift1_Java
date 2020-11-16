package uppgift2;

/*
* One to One associationer ( En - > En )
Definiera en klass Matte med en konstruktor som tar Mattes namn, samt en Katt. (Som objekt) Klassen skall ha operationer för att returnera Mattes namn samt katt-objektet.
•	Rita UML-diagram för Matte- och Katt-klasserna
•	Demonstrera klasserna med en Main klass.
*/
public class Matte {
    String mamaOwnerName;
    Cat catAsPet;

    public Matte(String mamaOwnerName, Cat catAsPet) {
        this.mamaOwnerName = mamaOwnerName;
        this.catAsPet = catAsPet;
    }

    public String getMamaOwnerName() {
        return mamaOwnerName;
    }

    public void setMamaOwnerName(String mamaOwnerName) {
        this.mamaOwnerName = mamaOwnerName;
    }

    public Cat getCatAsPet() {
        return catAsPet;
    }

    @Override
    public String toString() {
        return "Matte{" +
                "mamaOwnerName='" + mamaOwnerName + '\'' +
                ", catAsPet=" + catAsPet +
                '}';
    }
}//End of Matt Class
