package by.realdigital.test.cryptography;

import java.security.*;

public class Signature {

    public byte[] creatSign(byte[] data, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        java.security.Signature sign = java.security.Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(data);
        return sign.sign();
    }

    public boolean checkSign(byte[] data, byte[] signature, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        java.security.Signature sign = java.security.Signature.getInstance("SHA256withRSA");
        sign.initVerify(publicKey);
        sign.update(data);
        return sign.verify(signature);
    }
}
