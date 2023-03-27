package com.isep.view;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleScanner {
    static Scanner scanner;
    public ConsoleScanner(InputStream is){
        scanner = new Scanner(is);
    }

    public String getText() {
        return scanner.nextLine();
    }

    public int getInt(){return scanner.nextInt();}

}
