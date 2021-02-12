package com.arthur.stringsplit;

public class StringSplitTest {
    public static void main(String[] args) {
        String testString = "12 213 124";
        String[] tests = testString.split("\\s");
        for (String test : tests) {
            System.out.println(test);
        }
        String[] test2 = testString.split(" ");
        for (String s : test2) {
            System.out.println(s);
        }
    }
}
