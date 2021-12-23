package by.realdigital.test.io;

import java.util.Scanner;

public class InputConsoleImpl implements InputConsole {

    private final static String HELLO_MESSAGE = "1. For generate keys enter: " + System.lineSeparator()
            + "genkey and file_name" + System.lineSeparator()
            + System.lineSeparator()
            + "2. For signature enter: " + System.lineSeparator()
            + "sign and data_name_file.* and key_file_name" + System.lineSeparator()
            + System.lineSeparator()
            + "3. For check signature enter: " + System.lineSeparator()
            + "check and data_name_file.* and key_file_name.sign" + System.lineSeparator();

    @Override
    public String[] inputFromConsole() {
        Scanner in = new Scanner(System.in);
        System.out.print(HELLO_MESSAGE);
        return in.nextLine().split(" ");
    }
}
