package by.overone.hometask21.exercise2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class MainCountOfStrings {
    public static void main(String[] args) {
        String str = "Take my money my take money SHA";
        System.out.println(str);

        LinkedHashSet<String> stringLinkedHashSet = new LinkedHashSet<>(uniqueStrings(str));
        System.out.println(stringLinkedHashSet);
    }

    public static LinkedHashSet<String> uniqueStrings(String string1) {
        LinkedHashSet<String> setOfStrings = new LinkedHashSet<>();
        if (string1 == null) {
            setOfStrings.add("The string is NULL");
            return setOfStrings;
        }
        String[] words = string1.split("\\s");

        setOfStrings.addAll(Arrays.asList(words));
        return setOfStrings;
    }
}
