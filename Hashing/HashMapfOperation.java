import java.util.HashMap;

public class HashMapfOperation {
    public static void main(String[] args) {
        // Creat a HashMap

        HashMap<String, Integer> hm = new HashMap<>();

        // Insert(put operation)--Tc=O(1)
        hm.put("India", 100);

        hm.put("US", 50);

        hm.put("Nepal", 100);

        hm.put("Russ", 10);

        hm.put("China", 150);
        System.out.println(hm);

        // Get operation --.O(1)
        // getting the population of chaina
        int populaton = hm.get("India");
        System.out.println(populaton);

        // Containskey-->O(1)
        System.out.println(hm.containsKey("US"));
        System.out.println(hm.containsKey("Austrelia"));

        // Remove-->O(1)
        System.out.println(hm.remove("China"));
        System.out.println(hm);

        // Size-->O(1)
        System.out.println(hm.size());

        // Clear-->O(1)
        hm.clear();
        System.out.println(hm);

    }

}
