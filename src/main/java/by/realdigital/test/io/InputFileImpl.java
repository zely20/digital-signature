package by.realdigital.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class InputFileImpl implements InputFile {

    @Override
    public byte[] loadFromFiles(String fileName) {
        byte[] bytes = null;
        File file = Path.of(fileName).toFile();
        try (FileInputStream input = new FileInputStream(file)) {
            bytes = input.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
