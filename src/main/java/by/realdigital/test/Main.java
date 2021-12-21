package by.realdigital.test;

import by.realdigital.test.io.Input;
import by.realdigital.test.io.InputImpl;

public class Main {

    public static void main(String[] args) {
        Input input = new InputImpl();
        String[] string  = input.inputFromConsole();
        System.out.println(string);
    }
}
