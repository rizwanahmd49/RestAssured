package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestClass {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");
        int reversedNumber = 0, number = 12345;
        for (;number>0;number/=10){
            int temp=number%10;
            reversedNumber=reversedNumber*10+temp;

        }

        System.out.println(reversedNumber);
    }
}