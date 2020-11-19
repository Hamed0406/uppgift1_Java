package uppgift2.uppgift2_3;

import uppgift2.uppgift2_1.Dog;

import java.util.ArrayList;

/*
* Definiera en klass Husse. Definiera lämpliga operationer så att Husse har ett namn, kan äga många hundar samt kan tala om vad han heter och vilka hundar han äger.*/
public class Husse {
     private String husseName;
    private ArrayList<Dog> dogArrayListist=new ArrayList<Dog>();//List of Dog for a owner .

    public Husse(String husseName, ArrayList<Dog> dogArrayList) {
        this.husseName = husseName;
        this.dogArrayListist = dogArrayList;
    }

    public String getHusseName() {
        return husseName;
    }

    public void setHusseName(String husseName) {
        this.husseName = husseName;
    }

    public ArrayList<Dog> getDogArrayList() {
        return dogArrayListist;
    }


    public void addToDogList(Dog theDog)
    {
        dogArrayListist.add(theDog);
    }
    public void printDogOwnerNameAndDogs()
    {
        System.out.println("Dogs owner name is : "+husseName+" He is owner of ");
      int index=  dogArrayListist.size();//Number of element in the list .
        for(int i=0;i<index;i++)
        {
            System.out.println("Dog name is : "+ dogArrayListist.get(i).getDogName()+" Dog race is : "+dogArrayListist.get(i).getDogRace());
        }
    }

    @Override
    public String toString() {
        return "Husse{" +
                "husseName='" + husseName + '\'' +
                ", dogArrayListist=" + dogArrayListist +
                '}';
    }
}//End of Husse  class
