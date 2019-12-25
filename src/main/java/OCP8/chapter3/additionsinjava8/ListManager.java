package OCP8.chapter3.additionsinjava8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListManager {
    List<Duck> ducks = new ArrayList<>();

    {
        ducks.add(new Duck("sam", 4));
        ducks.add(new Duck("greg", 9));
        ducks.add(new Duck("sasha", 47));
        ducks.add(new Duck("pete", 6));
        ducks.add(new Duck("pete", 12));
        ducks.add(new Duck("sam", 3));
    }

    public List<Duck> getDucks() {
        return ducks;
    }

    private void listDisplay(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("#############################");
    }

    public static void main(String[] args) {
        ListManager lm = new ListManager();
        List<Duck> ducks = lm.getDucks();
        lm.listDisplay(ducks);

        Comparator<Duck> cName = Comparator.comparing(d -> d.getName());
        Collections.sort(ducks, cName);
        System.out.println("Comparator by name");
        lm.listDisplay(ducks);

        Comparator<Duck> cWeight = Comparator.comparing(d -> d.getWeight());
        Collections.sort(ducks, cWeight);
        System.out.println("comparator by weight");
        lm.listDisplay(ducks);

        Comparator<Duck> cNameWeight = Comparator.comparing(d -> d.getName());
        cNameWeight = cNameWeight.thenComparing(d -> d.getWeight());
        Collections.sort(ducks, cNameWeight);
        System.out.println("comparator NameWeight");
        lm.listDisplay(ducks);

        Comparator<Duck> cHelper = DuckHelper::compareByName;
        Comparator<Duck> cHelp_1 = (d1, d2) -> DuckHelper.compareByName(d1, d2);
        Comparator<Duck> ch = (a, a1) -> a.compareByName(a, a1);
        Collections.sort(ducks, ch);
        lm.listDisplay(ducks);
    }
}
