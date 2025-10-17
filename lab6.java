import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * lab6.java
 * fall 2025
 * 
 * caroline smith
 * 
 * convert String to double using Java Collection Stack and Queue
 */

public class lab6 {
    public static void main(String[] args) {

        // test cases - add x3 additional cases here
        test("6", 6.0);
        test("7,000,000", 7000000.0);
        test(" $$$7 000 000 ", 7000000.0);
        test("$5,678.13 ", 5678.13);
        test("$0.25", 0.25);
        test(" -$.25", -0.25);
        test("-8.96", -8.96);

        // *** add three additional test cases here
        test("3", 3.0);
        test("-2.2", -2.2);
        test("$ 5", 5.0);



    }// main

    private static double toDouble(String a) {

        double answer = 0.0;

        Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();

        //boolean decimalFound = false; // *** may or may not use this approach
        //boolean negative = false; // *** may or may not use this approach

        // *** add code here ***

        
        String cleaned = a.replace("$", "")
                            .replace(",", "")
                            .replace(" ", "");

        boolean negative = false; 
        if (cleaned.startsWith("-")) {
            negative = true;
            cleaned = cleaned.substring(1); 
        }

        String parts[] = cleaned.split("\\.");      //splits at the decimal
        String left = parts[0];                     //parts is what is before and after decimal; position 0 is before decimal
        String right = parts.length > 1 ? parts[1] : ""; //if length is greater than 1, meaning there is something after the decimal, then whatever is at position 1 is whatever is after the decimal; else, it is blank

        for (int i = 0; i < left.length(); i++) {
            char c = left.charAt(i);
            if (Character.isDigit(c)) {
                s.push(Character.getNumericValue(c));
            }
        }

        for (int i = 0; i < right.length(); i++) {
            char c = right.charAt(i);
            if (Character.isDigit(c)) {
                q.add(Character.getNumericValue(c));
            }
        }

        int multiplier = 1;
        while (!s.isEmpty()) {
            int digit = s.pop();
            answer += digit * multiplier;
            multiplier *= 10;
        }

        double divisor = 10.0;
        while (!q.isEmpty()) {
            int digit = q.remove();
            answer += digit / divisor;
            divisor *= 10;
        }

        if (negative) {
            answer *= -1;
        }


        return answer;

    }// toDouble

    // test method
    private static void test(String s, double expected) {

        double actual = toDouble(s);

        if (actual == expected)
            System.out.printf("Passed: %15s => %15f\n", s, actual);
        else
            System.out.printf(" Error: %15s => %15f   Expected: %15f\n", s, actual, expected);

    } // test

}// class
