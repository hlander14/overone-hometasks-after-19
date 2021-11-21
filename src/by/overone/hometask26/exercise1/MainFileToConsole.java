package by.overone.hometask26.exercise1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainFileToConsole {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        File file = new File("src/resources/h26e1.txt");
        FileReader fileReader = new FileReader(file);

        StringBuilder stringBuilder = new StringBuilder();
        int ch;
        while ((ch = fileReader.read()) != -1) {
            stringBuilder.append((char) ch);
        }

        String[] lines = stringBuilder.toString().split("\\n");
        for (String str : lines) {
            System.out.println(str);
        }

    }
}
