package com.amukoski.controller.console.inputreader;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Scanner;

@Component
public class ConsoleInputReader implements InputReader {

    private Scanner scanner;

    public ConsoleInputReader() {
        scanner = new Scanner(System.in);
    }

    public ConsoleInputReader(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public String readFromInput(String displayMessage) {
        System.out.print(displayMessage);
        return scanner.nextLine();
    }
}
