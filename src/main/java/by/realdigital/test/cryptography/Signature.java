package by.realdigital.test.cryptography;

import java.security.*;

public class Signature {

    public byte[] creatSign(byte[] data, PrivateKey privateKey ) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        java.security.Signature sign = java.security.Signature.getInstance("SHA256withDSA");
        sign.initSign(privateKey);
        sign.update(data);
        byte[] signature = sign.sign();
        return signature;
    }

    public boolean checkSign(byte[] data, PrivateKey privateKey, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        java.security.Signature sign = java.security.Signature.getInstance("SHA256withDSA");
        byte[] signature = creatSign(data, privateKey);
        sign.initVerify(publicKey);
        sign.update(data);
        return sign.verify(signature);
    }

}
