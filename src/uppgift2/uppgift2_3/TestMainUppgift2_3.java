package uppgift2.uppgift2_3;

import uppgift2.uppgift2_1.Dog;

import java.util.ArrayList;

public class TestMainUppgift2_3 {
    public static void main(String[] args) {
        Dog testDog = new Dog("Lilly", "boldag");//Create Dog object with constructor.

        ArrayList<Dog> testDogArrayList = new ArrayList<Dog>();
        testDogArrayList.add(testDog);

        Husse testHusse = new Husse("Hamed", testDogArrayList);
        Dog testDog1, testDog2;
        testDog1 = new Dog("Wolfy", "GermanShaper");//set name and race by constructor  for test1 .
        testDog2 = new Dog("Snow White", "Husky");//set name and race by constructor for test2 .

        testDogArrayList.add(testDog1);//Add to the list
        testDogArrayList.add(testDog2);//Add to the list

        testHusse.printDogOwnerNameAndDogs();

    }
}
