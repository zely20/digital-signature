package by.realdigital.test.io;

import java.security.Key;

public interface OutputFile {

    void createKeyFiles(String fileName, Key key, String suffix);

    void createJsonFile(String fileName, String json);
}
