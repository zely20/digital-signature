package by.realdigital.test.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;

public class OutputToFile {

    public void createFile(String fileName, KeyPair keyPair) {
        File secretFile = new File(fileName + ".sec");
        File openFile = new File(fileName + ".open");
        try (FileWriter fileOpenWriter = new FileWriter(openFile);
             FileWriter fileSecretWriter = new FileWriter(secretFile);) {
            fileOpenWriter.write(keyPair.getPublic().toString());
            fileSecretWriter.write(keyPair.getPrivate().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
