package OCP8.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetPartition {
    Set<Character> originSet = new HashSet<>();
    char c = 'a';
    private static final int PARTITION_COUNT = 5;

    public Set<Character> populateSet() {
        for (int i = 0; i < 239; i++) {
            originSet.add(c++);
        }
        return originSet;
    }

    public void setPartitioning() {
        populateSet();
        List<Set<Character>> setsList = new ArrayList<>(PARTITION_COUNT);

        for (int i = 0; i < PARTITION_COUNT; i++) {
            setsList.add(new HashSet<Character>());
        }

        int index = 0;
        for (Character character : originSet) {
            setsList.get(index++ % PARTITION_COUNT).add(character);
        }
        for (Set<Character> characters : setsList) {
            for (Character character : characters) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }
}
