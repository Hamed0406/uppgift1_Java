package uppgift2.uppgift2_1;
/*
* Definiera en klass Hund, med en konstruktor som tar hundens namn och ras. Klassen skall dessutom ha operationer som returnerar hundens namn respektive ras.
Definiera på samma sätt en klass Katt.
*/
public class Dog {
   private String dogName;
   private String dogRace;

    public Dog(String dogName, String dogRace) {
        this.dogName = dogName;
        this.dogRace = dogRace;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogRace() {
        return dogRace;
    }

    public void setDogRace(String dogRace) {
        this.dogRace = dogRace;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                ", dogRace='" + dogRace + '\'' +
                '}';
    }
}
