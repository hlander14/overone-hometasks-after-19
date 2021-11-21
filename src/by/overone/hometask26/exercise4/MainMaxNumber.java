package by.overone.hometask26.exercise4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MainMaxNumber {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        File file = new File("src/resources/h26e4.txt");
        FileReader fileReader = new FileReader(file);

        StringBuilder stringBuilder = new StringBuilder();
        int ch;
        while ((ch = fileReader.read()) != -1) {
            stringBuilder.append((char) ch);
        }

        String[] lines = stringBuilder.toString().split("\\n");
        for (String str : lines) {
            System.out.println(str);
            String[] stringDeep = str.split("[ .,]+");
            int count = 0;
            int position = 0;
            for (int i = 0; i < stringDeep.length; i++) {
                if (stringDeep[i].matches("^(?ui:[0123456789]).*")) {
                    if (count < stringDeep[i].length()) {
                        count = stringDeep[i].length();
                        position = i;
                    }
                }
            }
            System.out.println("The largest number in this string is: " + stringDeep[position]);
        }

    }
}
