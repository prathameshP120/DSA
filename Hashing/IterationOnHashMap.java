import java.util.*;

public class IterationOnHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Russ", 10);
        hm.put("Nepal", 5);

        Set<String> keys = hm.keySet();
        System.out.println(keys);
        System.out.println();

        for (String k : keys) {
            System.out.println("keys=" + k + " , value=" + hm.get(k));

        }

    }

}
