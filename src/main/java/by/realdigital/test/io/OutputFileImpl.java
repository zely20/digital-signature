package by.realdigital.test.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.security.Key;
import java.security.KeyPair;

public class OutputFileImpl implements OutputFile{

    @Override
    public void createKeyFiles(String fileName, Key key, String suffix) {
        File file = new File(fileName + suffix);
        try (FileOutputStream output = new FileOutputStream(file)) {
                output.write(key.getEncoded());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createJsonFile(String fileName, String json) {
        File file = Path.of(fileName + ".sign").toFile();
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
