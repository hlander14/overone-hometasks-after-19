package by.overone.hometask27.exerecise10;

import java.util.ArrayList;

public class MainTester {
    public static void main(String[] args) {
        ArrayList<Tester> testerArrayList = new ArrayList<>();
        testerArrayList.add(new Tester(1, "Pavel"));
        testerArrayList.add(new Tester(4, "bb"));
        testerArrayList.add(new Tester(2, "Semevov bb"));
        testerArrayList.add(new Tester(8, "Pubbertom"));
        testerArrayList.add(new Tester(156, "BbSemen"));
        testerArrayList.add(new Tester(2, "bbPavel"));
        testerArrayList.add(new Tester(758, "xdf hd h sdh bb xdh dh"));
        testerArrayList.add(new Tester(1024, "bbxdf hd h sdh bb xdh dh"));

        testerArrayList
                .stream()
                .filter(x -> x.getId() > 3
                        && x.getName().length() >= 2
                        && x.getName().charAt(0) == 'b'
                        && x.getName().charAt(1) == 'b')
                .forEach(System.out::println);
    }
}
