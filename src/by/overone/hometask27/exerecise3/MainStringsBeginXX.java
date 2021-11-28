package by.overone.hometask27.exerecise3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainStringsBeginXX {
    public static void main(String[] args) {
        Predicate<String> stringPredicate = x -> x.charAt(0) == 'X' && x.charAt(1) == 'X';

        List<String> stringList = new ArrayList<>();
        stringList.add("First");
        stringList.add("Second XX");
        stringList.add("");
        stringList.add("XX Third");
        stringList.add("Fourth");
        stringList.add("FiXXfth");
        stringList.add("XX");
        stringList.add("xx");

        getBeginXX(stringList, stringPredicate);
    }

    public static void getBeginXX(List<String> stringList, Predicate<String> operator){
        for (String strings : stringList) {
            if (strings.length() >= 2 && operator.test(strings)) {
                System.out.println(strings);
            }
        }
    }
}
