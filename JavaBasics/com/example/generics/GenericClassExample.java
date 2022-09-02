package com.example.generics;

public class GenericClassExample {
    public static void main(String[] args)  {
        NumericCalculator calculator = new LongCalculator();
        Long longInstance2 = new Long(15);
        System.out.println(calculator.sum(15L, longInstance2));
    }

}

interface NumericCalculator<T>{
    T sum(T a, T b);

}

class LongCalculator implements NumericCalculator<Long>{
    @Override
    public Long sum(Long a, Long b) {
        return a+b;
    }
}


