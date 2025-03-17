package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestClass {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");
        int reversedNumber = 0, number = 654321;
        while (number > 0) {
            int temp = number % 10;
            reversedNumber = reversedNumber * 10 + temp;
            number /= 10;
        }

        System.out.println(reversedNumber + "\n***********Done ***********\n");

        String string = "rizwana568hmadsalmani";
        char[] charArray = string.replaceAll("[^a-z A-Z]", "").toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : charArray) {
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);

        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }


}