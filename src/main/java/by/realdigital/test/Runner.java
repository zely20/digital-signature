package by.realdigital.test;

import by.realdigital.test.cryptography.GeneratedKey;
import by.realdigital.test.cryptography.Signature;
import by.realdigital.test.io.*;
import by.realdigital.test.mapper.SignMapper;
import by.realdigital.test.model.Sign;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Runner {
    boolean flag = true;

    public void run() {
        InputConsole inputConsole = new InputConsoleImpl();
        InputFile inputFile = new InputFileImpl();
        OutputFile outputToFile = new OutputFileImpl();
        GeneratedKey gk = new GeneratedKey();
        while (flag) {
            String[] dataFromConsole = inputConsole.inputFromConsole();
            switch (dataFromConsole[0]) {
                case "genkey":
                    if (dataFromConsole.length == 2) {
                        genKey(outputToFile, dataFromConsole);
                    } else {
                        System.out.println("Please check your data!!!");
                    }
                    break;
                case "sign":
                    if (dataFromConsole.length == 3) {
                        signData(inputFile, dataFromConsole, gk, outputToFile);
                    } else {
                        System.out.println("Please check your data!!!");
                    }
                    break;
                case "check":
                    if (dataFromConsole.length == 3) {
                        checkSign(inputFile, dataFromConsole);
                    } else {
                        System.out.println("Please check your data!!!");
                    }
                    break;
                case "exit":
                    exit();
                    break;
            }
        }
    }

    private void genKey(OutputFile outputToFile, String[] dataFromConsole) {
        GeneratedKey gk = new GeneratedKey();
        KeyPair keyPair = gk.getPairKey();
        outputToFile.createKeyFiles(dataFromConsole[1], keyPair.getPrivate(), ".sec");
        outputToFile.createKeyFiles(dataFromConsole[1], keyPair.getPublic(), ".open");
        System.out.println("Generated key is done!!!");
    }

    private void signData(InputFile inputFile, String[] dataFromConsole, GeneratedKey gk, OutputFile outputToFile) {
        byte[] dataFromFile = inputFile.loadFromFiles(dataFromConsole[1]);
        PrivateKey privateKey = gk.loadKeyFromFiles(dataFromConsole[2]).getPrivate();
        PublicKey publicKey = gk.loadKeyFromFiles(dataFromConsole[2]).getPublic();
        byte[] cratedSign = new byte[0];
        try {
            cratedSign = new Signature().creatSign(dataFromFile, privateKey);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        outputToFile.createJsonFile(dataFromConsole[2], SignMapper.signToJson(publicKey, dataFromConsole[2], cratedSign));
    }

    private void checkSign(InputFile inputFile, String[] dataFromConsole) {
        Signature signature = new Signature();
        byte[] dataFromFile = inputFile.loadFromFiles(dataFromConsole[1]);
        byte[] signDataFromFile = inputFile.loadFromFiles(dataFromConsole[2]);
        Sign sign = SignMapper.signFromJson(signDataFromFile);
        KeyFactory kf;
        try {
            kf = KeyFactory.getInstance("RSA");
            PublicKey publicKeyFromJson = kf.generatePublic
                    (new X509EncodedKeySpec(Base64.getDecoder().decode(sign.getKeyBase64())));
            if (signature.checkSign(dataFromFile, sign.getSignature(), publicKeyFromJson)) {
                System.out.println("digital signature is VALID");
            } else {
                System.out.println("digital signature is INVALID");
            }
        } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidKeySpecException | SignatureException e) {
            e.printStackTrace();
        }
    }

    private void exit() {
        this.flag = false;
    }
}
