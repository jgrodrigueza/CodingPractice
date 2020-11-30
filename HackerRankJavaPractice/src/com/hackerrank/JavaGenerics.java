//https://www.hackerrank.com/challenges/java-generics/problem

package com.hackerrank;

import java.io.IOException;
import java.lang.reflect.Method;

class Printer
{
    public static <Gen> void printArray(Gen[] inputArray ) {
        for (int pos = 0; pos < inputArray.length; pos++) {
            System.out.println(inputArray[pos]);
        }
    }
}

public class JavaGenerics {

    public static void main( String args[] ) {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");
      
    }
}
