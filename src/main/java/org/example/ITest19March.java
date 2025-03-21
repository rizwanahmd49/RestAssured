package org.example;
import java.util.Scanner;

public class ITest19March {


 private static void factorialOfNumber() {
     int number= 0;
     //File file=new File("src/test/resources/ScannerInput.txt");
     Scanner scan;
     int factorial= 0;
     try {
         scan=new Scanner(System.in);
         number = scan.nextInt();
         if (number>10){
             System.out.println("Please enter number up to 10");
             factorialOfNumber();
             System.exit(0);
         }
         factorial = 1;
         for (int i = 1; i <=number ; i++) {
             factorial=factorial*i;
         }
         scan.close();
     } catch (Exception e) {
         throw new RuntimeException(e);
     }
     System.out.println("Factorial of "+number+" is : "+factorial);
 }
 private void isPrimeNumber(int number){
        if (number%2==0)
            System.out.println("Number is Prime");

 }

 //
    public static void main(String[] args) {
        factorialOfNumber();



    }
}
