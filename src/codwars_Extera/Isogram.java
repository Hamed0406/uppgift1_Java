package codwars_Extera;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Isogram {
    String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static   boolean  isIsogram(String str) {
        // ..
        Boolean answer=true;
        int lenth=str.length();
        str=str.toLowerCase();
        for(int i=0;i<lenth;i++)
        {
            char temp;
            temp=str.charAt(i);
            for(int j=0;j<lenth;j++)
                if(i!=j)
                    if(str.charAt(j)==temp)
                    answer=false;

           // str.toLowerCase().chars().distinct().count()
        }
     /*  if(answer==true)
            System.out.println("IS ISOGRAM");
        if(answer==false)
            System.out.println("IS  Not ISOGRAM");
*/
        return answer;
    }
   /* public static void main(String[] args)
    {
        Isogram test =new Isogram();
        test.setStr("abba");
        test.isIsogram(test.getStr());
        test.setStr("hamed");
        test.isIsogram(test.getStr());
      test.setStr("aba");
       test.isIsogram(test.getStr());
    }
*/


}//End of class
