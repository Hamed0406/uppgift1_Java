package V39;
//Skriv ett program som kan spela sten/sax/påse med användaren.


import java.util.Random;
import java.util.Scanner;

public class Ssp {
    public static void main(String args[]){
int max=3;
int min=1;
boolean flag=true;
        int userPick;
        int pcPick;
      /*  Random r = new Random();
        int pcPick= r.nextInt((max - min) + 1) + min;
        int userPick;
        System.out.println("Please enter your pick: #1 for sten ,#2 for Sax , #3 for påse");
        Scanner sc=new Scanner(System.in);
        userPick=sc.nextInt();*/
        int answer;
        Scanner scInt=new Scanner(System.in);

        while(flag){
            Random r = new Random();
            pcPick= r.nextInt((max - min) + 1) + min;
            System.out.println("Please enter your pick: #1 for sten ,#2 for Sax , #3 for påse #0 for Exit");
            Scanner sc=new Scanner(System.in);
            userPick=sc.nextInt();
            if(userPick==0){
                flag=false;
            }
            if(userPick==1){
                System.out.println("You picked sten");
            }
            if(userPick==2){
                System.out.println("You picked Sax");
            }
            if(userPick==3){
                System.out.println("You picked påse");

            }
            if(userPick==1&&pcPick==2){
                System.out.println("You wined , Pc picked Sax");
                System.out.println("Do you want to give a new tyr ? Please enter 9 for new round and 0 for exit");
                answer=scInt.nextInt();
if(answer==0){
    flag=false;
}
if(answer==9){
    flag=true;
}
            }
            if(userPick==1&&pcPick==3){
                System.out.println("You loosed , Pc picked Påse");
                System.out.println("Do you want to give a new tyr ? Please enter 9 for new round and 0 for exit");
                answer=scInt.nextInt();
                if(answer==0){
                    flag=false;
                }
                if(answer==9){
                    flag=true;
                }
            }
           if(userPick==2&&pcPick==1) {
               System.out.println("You loosed , Pc picked Sten");
               System.out.println("Do you want to give a new tyr ? Please enter 9 for new round and 0 for exit");
               answer=scInt.nextInt();
               if(answer==0){
                   flag=false;
               }
               if(answer==9){
                   flag=true;
               }
           }
            if(userPick==2&&pcPick==3){
                System.out.println("You wined , Pc picked Påse");
                System.out.println("Do you want to give a new tyr ? Please enter 9 for new round and 0 for exit");
                answer=scInt.nextInt();
                if(answer==0){
                    flag=false;
                }
                if(answer==9){
                    flag=true;
                }
            }
            if(userPick==3&&pcPick==1){
                System.out.println("You wined , Pc picked Sten");
                System.out.println("Do you want to give a new tyr ? Please enter 9 for new round and 0 for exit");
                answer=scInt.nextInt();
                if(answer==0){
                    flag=false;
                }
                if(answer==9){
                    flag=true;
                }

            }
            if(userPick==3&&pcPick==2){
                System.out.println("You lossed , Pc picked Sax");
                System.out.println("Do you want to give a new tyr ? Please enter 9 for new round and 0 for exit");
                answer=scInt.nextInt();
                if(answer==0){
                    flag=false;
                }
                if(answer==9){
                    flag=true;
                }
            }
            if(userPick==pcPick){
                System.out.println("Try again , Pair pickecd");
                System.out.println("Do you want to give a new tyr ? Please enter 9 for new round and 0 for exit");
                answer=scInt.nextInt();
                if(answer==0){
                    flag=false;
                }
                if(answer==9){
                    flag=true;
                }
            }

        }


    }
}
