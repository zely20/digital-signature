package by.realdigital.test;

import by.realdigital.test.cryptography.GeneratedKey;
import by.realdigital.test.cryptography.Signature;
import by.realdigital.test.io.*;
import by.realdigital.test.model.Sign;

import java.security.*;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Input input = new InputImpl();
        InputFile inputFile = new InputFileImpl();

        GeneratedKey gk = new GeneratedKey();
        boolean flag = true;
        while (flag) {
            String[] string = input.inputFromConsole();
            if (string[0].equals("genkey")) {
                OutputFile outputToFile = new OutputFileImpl();
                gk = new GeneratedKey();
                KeyPair keyPair = gk.getPairKey();
                outputToFile.createKeyFiles(string[1], keyPair.getPrivate(), ".sec");
                outputToFile.createKeyFiles(string[1], keyPair.getPublic(), ".open");
            } else if (string[0].equals("sign")) {
                byte[] dataFromFile = inputFile.loadFromFiles(string[1], ".txt");
                Signature signature = new Signature();
                PrivateKey privateKey = gk.loadKeyFromFiles(string[2]).getPrivate();
                PublicKey publicKey = gk.loadKeyFromFiles(string[2]).getPublic();
                byte[] cratedSign = signature.creatSign(dataFromFile, privateKey);
                Sign sign = new Sign(cratedSign, string[2], publicKey);
                System.out.println(sign);
            } else if(string[0].equals("exit")) {
                flag = false;
            }
        }
    }
}
