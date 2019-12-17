package OCP8.concurrency;

import java.util.*;

public class ConcurrencyCollections {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("one", 23);
        map.put("two", 65);
        map.put("three", 120);
        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();
        for (String i = ""; it.hasNext(); i = it.next()) {
            if (i.equalsIgnoreCase("one"))
                it.remove();
        }
        for (String s : map.keySet()) {
            System.out.println("key : " + s);
        }

    }
}
