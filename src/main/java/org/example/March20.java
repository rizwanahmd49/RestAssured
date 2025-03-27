package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class March20 {

    //Check if the string is palindrome
    private static void validateStringAsPalindrome(String string) {
        string = string.replaceAll("[^a-zA-Z]", "").toUpperCase();
        char[] charArray = string.toCharArray();
        String reverse = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            reverse += charArray[i];
        }
        if (reverse.equals(string))
            System.out.println("String is Palindrome");
        else
            System.out.println("String is NOT Palindrome");


    }

    private static void printFibonacciSeries() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int first = 0, second = 1;
        System.out.print(first + ", " + second);
        for (int i = 1; i <= number; i++) {
            int fibo = first + second;
            first = second;
            second = fibo;

            System.out.print(", " + fibo);

        }
    }

    /**
     * Reverse the words in given string and to do not change the index of the word
     * Exp: rizwan ahamd salmani
     * nawzir dmaha inamlas
     *
     * @param string
     */
    private static void reverseWordInString(String string) {
        String[] splitedString = string.split(" ");
        int strLength = splitedString.length;
        for (int i = 0; i < strLength; i++) {
            char[] charArray = splitedString[i].toCharArray();
            int length = charArray.length - 1;
            for (int j = length; j >= 0; j--) {
                System.out.print(charArray[j]);

            }
            System.out.print(" ");

        }

    }


    private static void findSecondHighestNumber(int[] intArray) {
        int high = Integer.MIN_VALUE;
        int secondHigh = Integer.MIN_VALUE;
        int length = intArray.length;
        for (int i = 0; i < length; i++) {
            if (intArray[i] > high) {
                secondHigh = high;
                high = intArray[i];
            } else if (intArray[i] > secondHigh && intArray[i] < high)
                secondHigh = intArray[i];

        }
        System.out.println("Second High: " + secondHigh);
    }



    private static void findDuplicateChar(String string) {
        System.out.println("Provided String : " + string);
        string=string.replaceAll(" ","");
        System.out.println("removed space from String");
        Map <Character,Integer>map=new HashMap<>();
        char[] charArray = string.toCharArray();
        Map<Character, Long> data = new String(charArray)
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<Character, Long> mp:data.entrySet())
            System.out.println(mp.getKey()+" => "+mp.getValue());




    }

    public static void main(String[] args) {
        String fname="rizwan";
        fname=fname+"ahmad";
        String firstName="rizwanahmad";
        if (firstName==fname)
            System.out.println("Both name are equals");
        else
            System.out.println("Name are not equals");
        if (firstName.equals(fname))
            System.out.println("Name is equals");
        findDuplicateChar("rizwan5642ahmad4568salmani");
    }

}
