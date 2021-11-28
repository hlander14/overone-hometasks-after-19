package by.overone.hometask27.exerecise9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainStreamAA {
    public static void main(String[] args) {
        ArrayList<String> listOfString = new ArrayList<>();
        listOfString.add("dshsd fh sdh sdh");
        listOfString.add("bdbdfb");
        listOfString.add("363yehaaaaaaaaaavrh h gh d");
        listOfString.add("dfj yj dyjaa");
        listOfString.add("");
        listOfString.add("aasthsth sthj sthsth");
        listOfString.add("aa");
        listOfString.add("dhdhdhdhdf aa");

        listOfString.stream()
                .filter(x -> x.length() >= 2
                        && x.charAt(0) == 'a'
                        && x.charAt(1) == 'a')
                .forEach(System.out::println);
    }
}
