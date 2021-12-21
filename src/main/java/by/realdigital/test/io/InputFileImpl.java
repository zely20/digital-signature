package by.realdigital.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class InputFileImpl implements InputFile {

    @Override
    public byte[] loadFromFiles(String fileName, String suffixFile)  {
        byte[] bytes= null;
        File secretKeyFile = Path.of(fileName + suffixFile).toFile();
        try (FileInputStream input = new FileInputStream(secretKeyFile)){
            bytes = input.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
