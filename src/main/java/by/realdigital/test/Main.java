package by.realdigital.test;

import by.realdigital.test.cryptography.GeneratedKey;
import by.realdigital.test.io.Input;
import by.realdigital.test.io.InputImpl;
import by.realdigital.test.io.OutputToFile;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Input input = new InputImpl();
        String[] string  = input.inputFromConsole();
        if(string[0].equals("genkey")) {
            OutputToFile outputToFile = new OutputToFile();
            outputToFile.createFile(string[1],new GeneratedKey().getPairKey());
        }
        GeneratedKey key = new GeneratedKey();
        System.out.println("private key = " + key.getPairKey().getPrivate());
        System.out.println("open key = " + key.getPairKey().getPublic());
    }
}
