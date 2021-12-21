package by.realdigital.test;

import by.realdigital.test.cryptography.GeneratedKey;
import by.realdigital.test.io.*;

import java.security.KeyPair;

public class Main {

    public static void main(String[] args) {
        Input input = new InputImpl();
        String[] string  = input.inputFromConsole();
        GeneratedKey gk = new GeneratedKey();
        if(string[0].equals("genkey")) {
            OutputFile outputToFile = new OutputToFile();
            gk = new GeneratedKey();
            KeyPair keyPair = gk.getPairKey();

            outputToFile.createKeyFiles(string[1], keyPair.getPrivate(), ".sec");
            outputToFile.createKeyFiles(string[1], keyPair.getPublic(), ".open");
            System.out.println(keyPair.getPublic().toString());
            System.out.println(keyPair.getPrivate().toString());
        } else if(string[0].equals("sign")) {

        }
        KeyPair keysFromFiles = gk.loadKeyFromFiles(string);
        System.out.println("____________________________________________________");
        System.out.println(keysFromFiles.getPublic().toString());
        System.out.println(keysFromFiles.getPrivate().toString());

    }
}
