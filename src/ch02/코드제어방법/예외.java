package ch02.코드제어방법;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class JavaFilePrinter {

    public void readFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println(reader.readLine());
        }
    }

}

public class 예외 {
    public static void main(String[] args) throws IOException {
    }

}