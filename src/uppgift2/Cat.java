package uppgift2;
/*Definiera en klass Hund, med en konstruktor som tar hundens namn och ras. Klassen skall dessutom ha operationer som returnerar hundens namn respektive ras.
Definiera på samma sätt en klass Katt.

* */
public class Cat {
    String cattName;
    String catRace;
    Matte catOwner;

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

    public Cat(String cattName, String catRace) {
        this.cattName = cattName;
        this.catRace = catRace;
    }

    public String getOwnerName(Matte catOwner)
    {
        return catOwner.getMamaOwnerName();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "cattName='" + cattName + '\'' +
                ", catRace='" + catRace + '\'' +
                '}';
    }
}
