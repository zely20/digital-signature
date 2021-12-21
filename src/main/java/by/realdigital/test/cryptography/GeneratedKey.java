package by.realdigital.test.cryptography;

import by.realdigital.test.io.InputFile;
import by.realdigital.test.io.InputFileImpl;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class GeneratedKey {

    public KeyPair getPairKey () {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        keyPairGenerator.initialize(2048, new SecureRandom());
        return keyPairGenerator.generateKeyPair();
    }

    public KeyPair loadKeyFromFiles(String [] arrayFromConsole) {
        PrivateKey privateKey = null;
        PublicKey publicKey = null;
        InputFile inputFile = new InputFileImpl();
        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            privateKey = kf.generatePrivate
                    (new PKCS8EncodedKeySpec(inputFile.loadFromFiles(arrayFromConsole, ".sec")));
            publicKey = kf.generatePublic(new X509EncodedKeySpec(inputFile.loadFromFiles(arrayFromConsole, ".open")));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return new KeyPair(publicKey, privateKey);
    }


}
