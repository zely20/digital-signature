package by.realdigital.test.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;

public class OutputToFile {

    public void createFile(String fileName, KeyPair keyPair) {
        File secretFile = new File(fileName + ".sec");
        File openFile = new File(fileName + ".open");
        try (FileWriter fileOpenWriter = new FileWriter(openFile);
             FileWriter fileSecretWriter = new FileWriter(secretFile);
             FileOutputStream fio = new FileOutputStream(secretFile)) {
            fio.write(keyPair.getPrivate().getEncoded());
           /* fileOpenWriter.write(keyPair.getPublic().getEncoded());
            fileSecretWriter.write(keyPair.getPrivate().getEncoded());*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
