package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.PrintStream;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestClass {


    //A simple Java program to check if a string is a palindrome involves reversing the string and comparing it to the original. Want to dive into it?
@Test
    private void isStringPalindrome(){
        String string="rizwa1526 48s  n";
        string=string.toLowerCase().replaceAll(" ","");
        string=string.replaceAll("[^a-z A-Z]","");
        char[] charArray = string.toCharArray();
        int length=charArray.length;
        //StringBuilder sb=new StringBuilder();
    String sb = "";
        for (int i=length-1;i>=0;i--){
            sb=sb+charArray[i];
        }
        System.out.println(sb);
    //Assert.assertEquals(string,sb.toString());
    if (string.contentEquals(sb))
        System.out.println("String is Palindrome!");
    else
        System.out.println("String is NOT Palindrome");
    }

private static void checkPalindrome(String string){
    System.out.println("Given String is: "+string);
    String     modifiedString = string
            //.replaceAll("[^a-zA-Z]", "")
            .replaceAll(" ", "")
            .toLowerCase();
    StringBuilder stringBuilder=new StringBuilder(modifiedString);
    String reversedString=stringBuilder.reverse().toString();
    System.out.println("Reversed string is : "+stringBuilder);
    if (reversedString.equals(modifiedString))
        System.out.println("Given String is Palindrome");
    else
        System.out.println("Given String is NOT Palindrome");
}

    /**
     * FThe Fibonacci series is a sequence where each number is the sum of
     * the two preceding numbers, usually starting from 0 and 1.
     * The sequence goes: 0, 1, 1, 2, 3, 5, 8, 13, 21, and so on.
     *
     * @param num
     */
    private static void printFibonacciSeries(int num){
        int first =0,second=1;
        PrintStream printf = System.out.printf(first+", "+second+", ");
        for (int i = 0; i < num-2; i++)
        {
            int next=first+second;
            first=second;
            second=next;
            System.out.print(next+", ");

        }


}

    public static void main(String[] args) {
    printFibonacciSeries(10);

    }
    private static int secondHighestNumber(int []array){
        return 0;

    }

}