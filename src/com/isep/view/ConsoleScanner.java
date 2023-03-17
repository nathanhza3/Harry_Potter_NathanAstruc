package com.isep.view;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleScanner {
    Scanner scanner;
    public ConsoleScanner(InputStream is){
        scanner = new Scanner(is);
    }

    public String getText() {
        return scanner.nextLine();
    }

}
