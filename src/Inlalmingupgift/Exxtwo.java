package Inlalmingupgift;

/*
* Uppgift 2
En bra löpare springer 24 miles på 1 timme, 40 minuter och 35 sekunder. 1 mile kan avrundas till 1,6 kilometer.

User story
Som en bra löpare vill jag vet min snitthastighet i kilometer per timme.
* */

public class Exxtwo {
    public static void main(String args[])
    {
       double  s=((60+40)*60)+35 ;//Running time in seconds. one hour is 3600 seconds.
       double d=24*1.4;//Distance in Kilometer.
        double resultInKilometer=(3600*d)/s;
        System.out.print("You run ");
        System.out.print(resultInKilometer);
        System.out.print(" km/h exactly.");
        System.out.print(" In other words you run ~ : ");
        System.out.print(Math.round(resultInKilometer));
        System.out.print(" km/h.");







    }
}
