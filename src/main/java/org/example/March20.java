package org.example;

import java.util.Arrays;
import java.util.Scanner;

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


    public static void main(String[] args) {

        findDuplicateCharacters("rizwanahmadsalmani");
    }

    private static void findDuplicateCharacters(String string) {
        System.out.println("Provided String is: " + string);
        string = string.replaceAll("[^0-9]]", "");
        System.out.println("After removing all special characters is" + string);
        String fu = "";
        int count = 0;
        char[] charArray = string.toLowerCase().toCharArray();
        int size = charArray.length - 1;
        for (int i = 0; i <= size; i++) {
            count=0;
            for (int j = 0; j <= size; j++) {
                if (charArray[i] == charArray[j]) {
                    count += 1;
                }
            }

            System.out.print(charArray[i] + " => ");
            System.out.print(count+"\n");


        }

    }


}
