package V38;
/*
*  Utforska System-klassen och se om du kan skriva ut följande information om Java:

Expected Output

Java Version: 1.8.0_191
Java Runtime Version: 1.8.0_191-b12
Java Home: C:\Program Files\Java\jre1.8.0_191
Java Vendor: Oracle Corporation
Java Vendor URL: http://java.oracle.com/
Java Class Path: C:\..
* */
public class Extra4 {
public static void main(String args[]){
    System.out.println("Java Version:"+System.getProperty("java.version"));
    System.out.println("Java Runtime Version:"+System.getProperty("java.runtime.version"));
    System.out.println("Java Home: "+System.getProperty("java.home"));
    System.out.println("Java Vendor:"+System.getProperty("java.vendor"));
    System.out.println("Java Vendor URL:"+System.getProperty("java.vendor.url"));
    System.out.println("Java Class Path:"+System.getProperty("java.class.path"));





}
}
