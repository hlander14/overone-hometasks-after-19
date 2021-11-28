package by.overone.hometask27.exerecise11;

import by.overone.hometask27.exerecise10.Tester;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainTesterName {
    public static void main(String[] args) {
        ArrayList<Tester> testerArrayList = new ArrayList<>();
        testerArrayList.add(new Tester(1, "Pavel"));
        testerArrayList.add(new Tester(4, "Korablev"));
        testerArrayList.add(new Tester(2, "Semevov bb"));
        testerArrayList.add(new Tester(8, "Pubbertom"));
        testerArrayList.add(new Tester(156, "BbSemen"));
        testerArrayList.add(new Tester(2, "bbPavel"));
        testerArrayList.add(new Tester(758, "Kirkorov"));
        testerArrayList.add(new Tester(1024, "Quetzalcoatlus"));

        List<String> listName = testerArrayList
                                    .stream()
                                    .map(Tester::getName)
                                    .collect(Collectors.toList());

        System.out.println(listName);
    }
}
