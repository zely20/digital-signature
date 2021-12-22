package by.realdigital.test.model;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Objects;

public class Sign implements Serializable {

    static final long serialVersionUID = 6604384152789567654L;
    private byte[] signature;
    private String fileName;
    private String keyBase64;

    public Sign() {
    }

    public Sign(byte[] signature, String fileName, String keyBase64) {
        this.signature = signature;
        this.fileName = fileName;
        this.keyBase64 = keyBase64;
    }

    public byte[] getSignature() {
        return signature;
    }

    public String getFileName() {
        return fileName;
    }

    public String getKeyBase64() {
        return keyBase64;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sign sign = (Sign) o;
        return Arrays.equals(signature, sign.signature) && Objects.equals(fileName, sign.fileName) && Objects.equals(keyBase64, sign.keyBase64);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fileName, keyBase64);
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }
}