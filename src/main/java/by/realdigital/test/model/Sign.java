package by.realdigital.test.model;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Objects;

public class Sign implements Serializable {

    static final long serialVersionUID = 6604384152789567654L;
    private byte[] signature;
    private String fileName;
    private PublicKey publicKey;

    public Sign(byte[] signature, String fileName, PublicKey publicKey) {
        this.signature = signature;
        this.fileName = fileName;
        this.publicKey = publicKey;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "signature=" + Arrays.toString(signature) +
                ", fileName='" + fileName + '\'' +
                ", publicKey=" + publicKey +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sign sign = (Sign) o;
        return Arrays.equals(signature, sign.signature) &&
                Objects.equals(fileName, sign.fileName) &&
                Objects.equals(publicKey, sign.publicKey);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fileName, publicKey);
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }
}