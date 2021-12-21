package by.realdigital.test.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;

public class OutputToFile implements OutputFile{

    @Override
    public void createKeyFiles(String fileName, Key key, String suffix) {
        File file = new File(fileName + suffix);
        try (FileOutputStream output = new FileOutputStream(file)) {
            output.write(key.getEncoded());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
