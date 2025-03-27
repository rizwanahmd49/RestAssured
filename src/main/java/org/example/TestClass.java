package org.example;

import org.testng.annotations.Test;

import java.io.PrintStream;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestClass {


    //A simple Java program to check if a string is a palindrome involves reversing the string and comparing it to the original. Want to dive into it?
    @Test
    private void isStringPalindrome() {
        String string = "rizwa1526 48s  n";
        string = string.toLowerCase().replaceAll(" ", "");
        string = string.replaceAll("[^a-z A-Z]", "");
        char[] charArray = string.toCharArray();
        int length = charArray.length;
        //StringBuilder sb=new StringBuilder();
        String sb = "";
        for (int i = length - 1; i >= 0; i--) {
            sb = sb + charArray[i];
        }
        System.out.println(sb);
        //Assert.assertEquals(string,sb.toString());
        if (string.contentEquals(sb))
            System.out.println("String is Palindrome!");
        else
            System.out.println("String is NOT Palindrome");
    }

    private static void checkPalindrome(String string) {
        System.out.println("Given String is: " + string);
        String modifiedString = string
                //.replaceAll("[^a-zA-Z]", "")
                .replaceAll(" ", "")
                .toLowerCase();
        StringBuilder stringBuilder = new StringBuilder(modifiedString);
        String reversedString = stringBuilder.reverse().toString();
        System.out.println("Reversed string is : " + stringBuilder);
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
    private static void printFibonacciSeries(int num) {
        int first = 0, second = 1;
        PrintStream printf = System.out.printf(first + ", " + second + ", ");
        for (int i = 0; i < num - 2; i++) {
            int next = first + second;
            first = second;
            second = next;
            System.out.print(next + ", ");

        }


    }



    /**
     * A factorial is a mathematical operation that multiplies positive integers below it.
     * For example, the factorial of 5 is 5 * 4 * 3 * 2 * 1 = 120
     *
     * @param number
     * @return
     */
    private static int factorialOfNumber(int number) {
        int factorial = 1;
        for (int i = number; i >= 1; i--) {
            factorial = factorial * i;
        }
        System.out.println("\nThe Factorial of the Number '" + number + "' is: = " + factorial);
        return factorial;
    }

    private static int findSecondHighestNumber(int[] array) {
        System.out.println("*********Second Highest Number*********");
        System.out.println(Arrays.toString(Arrays.stream(array).toArray()));
        Arrays.sort(array);
        System.out.println("Array After applies sorting\n"+Arrays.toString(array));
        int length = array.length - 2;
        int secondHighestNumber = array[length];
        System.out.println("Second Highest Number : " + array[length]);
        return secondHighestNumber;

    }

public class SecondHighest {
    public static int findSecondHighest(int[] arr) {
        if (arr.length < 2) {
            throw new RuntimeException("Array must have at least two elements");
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        if (secondMax == Integer.MIN_VALUE) {
            throw new RuntimeException("No second highest element found");
        }
        return secondMax;
    }
}
    public static void main(String[] args) {
      /*  printFibonacciSeries(10);
        factorialOfNumber(5);
        findSecondHighestNumber(new int[]{10, 20, 30, 99, 160, 90, 99});*/
        int[] array = {9, 8, 10, 30, 41, 45,45,41};
        System.out.println("Second Highest Number: "+SecondHighest.findSecondHighest(array));;
    }

}