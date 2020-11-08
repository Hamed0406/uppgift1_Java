package codwars_Extera;

public class JadenCase {
    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    String phrase;
    public String toJadenCase(String phrase) {
        // TODO put your code below this comment
        int length=phrase.length();
      /*  if(phrase==null)
            return phrase;
        if(phrase.isEmpty())
            return phrase;*/
        for(int i=0;i<length;i++)
        {


            if(i==0) {
                char   temp = Character.toUpperCase(phrase.charAt(i));
                phrase=phrase.replace(phrase.charAt(i),temp);
            }

            if(phrase.charAt(i)==' ' ){
                char   temp1 = Character.toUpperCase(phrase.charAt(i));
                phrase=phrase.replace(phrase.charAt(i),temp1);
            }

        }//End of for with i
       System.out.println(phrase);
return  phrase;
    }
    public static void main(String[] args)
    {
       JadenCase test = null;
       test.setPhrase("hamed adeli");
    }
}