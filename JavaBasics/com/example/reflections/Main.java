package com.example.reflections;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main customer = new Main();
        customer.reflectClass();
    }


    public void readArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void printArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void printVariableArguments(int... variables) {
        for (int i : variables) {
            System.out.println(i);
        }
    }

    public int readFromFile() throws IOException {
        int sum = 0;
        Scanner fileScanner = new Scanner(new File("/Users/maleehakhalid/Documents/Practice/Java/TestJava/src/input.txt"));
        while (fileScanner.hasNextInt()){
            sum += fileScanner.nextInt();
        }
        return sum;
    }


    public boolean checkPasswordFormat(String password) {
        /*Pattern matches the password to meet the following requirements:
         A digit, a lower case letter, an upper case letter, a special character must occur at least once
         No whitespace allowed in the entire string
         At least 8 characters
        * */
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        Pattern pattern = Pattern.compile(regex);

        Matcher m = pattern.matcher(password);

        return m.matches();

    }

    public void reflectClass() {
        Dog d1 = new Dog();
        Class obj = d1.getClass();

        String name = obj.getName();
        System.out.println("Name: " + name);

        int modifiers = obj.getModifiers();
        System.out.println("Class Modifier: " + modifiers);

        String modifierName = Modifier.toString(modifiers);
        System.out.println("Class Modifier Name: " + modifierName);

        Class superClass = obj.getSuperclass();
        System.out.println("Super class: " + superClass.getName());


    }
}