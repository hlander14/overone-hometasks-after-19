package by.overone.hometask26.exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainStrings {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        File file = new File("src/resources/h26e3.txt");
        FileReader fileReader = new FileReader(file);

        StringBuilder stringBuilder = new StringBuilder();
        int ch;
        while ((ch = fileReader.read()) != -1) {
            stringBuilder.append((char) ch);
        }

        String[] lines = stringBuilder.toString().split("[,.]*\\s+");

        for (int i = 0; i < lines.length-1; i++) {
            if (lines[i].charAt(lines[i].length() - 1) == lines[i + 1].charAt(0)) {
                System.out.println(lines[i] + " => " + lines[i + 1]);
            }
        }
    }
}
