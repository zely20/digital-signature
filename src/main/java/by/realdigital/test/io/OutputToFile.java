package by.realdigital.test.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;

public class OutputToFile implements OutputFile{

    @Override
    public void createKeyFiles(String fileName, KeyPair keyPair) {
        File secretFile = new File(fileName + ".sec");
        File openFile = new File(fileName + ".open");
        try (FileOutputStream outputSecret = new FileOutputStream(secretFile);
             FileOutputStream outputPublic = new FileOutputStream(openFile)) {
            outputSecret.write(keyPair.getPrivate().getEncoded());
            outputPublic.write(keyPair.getPublic().getEncoded());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
