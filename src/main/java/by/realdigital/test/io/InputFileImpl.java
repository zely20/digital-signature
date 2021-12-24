package by.realdigital.test.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputFileImpl implements InputFile {

    @Override
    public byte[] loadFromFiles(String fileName) {
        File file = new File(fileName);
        byte[] bytes = new byte[(int) file.length()];
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(file));
            dataInputStream.readFully(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }
}
