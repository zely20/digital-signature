package by.realdigital.test.mapper;

import by.realdigital.test.model.Sign;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.PublicKey;
import java.util.Base64;

public class SignMapper {

    public static String signToJson(PublicKey publicKey, String fileName, byte[] cratedSign) {
        String json = null;
        String keyBase64 = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        Sign sign = new Sign(cratedSign, fileName, keyBase64);
        try {
            json = new ObjectMapper().writeValueAsString(sign);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static Sign signFromJson(byte[] dataFromFile) {
        String json = new String(dataFromFile);
        Sign sign = null;
        try {
            sign = new ObjectMapper().readValue(json, Sign.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return sign;
    }
}
