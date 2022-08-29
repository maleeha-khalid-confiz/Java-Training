package com.example.generics;

public class GenericMethodExample {
    public static void main(String[] args)  {
        System.out.println(findMax(3,5));
        System.out.println(sayHi("Maleeha",23));
    }

    /*iN ORDER TO COMPARE THE USER DEFINED CLASS OBJECTS. WE USE COMPARABLE WHICH HAS A SINGLE METHOD: COMPARETO*/
    public static <T extends Comparable<T>> T findMax(T a, T b){
        return ( a.compareTo(b) > 0 )? a: b;
    }

    public static <Y, Z> Y sayHi(Y name, Z age){
        return (Y) ("Hello " + name+ " with the "+age);
    }
}


