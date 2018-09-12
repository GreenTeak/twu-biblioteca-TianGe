package com.twu.biblioteca.input;

import java.util.Scanner;

public class ScannerInputSource implements InputSource {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getInput() {
        return scanner.next();
    }

    @Override
    public boolean hasInput() {
        return scanner.hasNext();
    }
}
