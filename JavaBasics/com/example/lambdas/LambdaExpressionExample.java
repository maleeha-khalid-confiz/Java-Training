package com.example.lambdas;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressionExample {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("Mango");
        list.add("Apple");
        list.add("Banana");
        list.add("Grapes");

        list.forEach(i -> System.out.println("Hello "+ i));

        FunctionalInterface functionalInterface = (int x)->System.out.println(2*x);
        functionalInterface.print(5);

    }
}

interface FunctionalInterface{
    void print(int name); //only one abstract method

    default void normalPrint()
    {
        System.out.println("Hello");
    }
}





