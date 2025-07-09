import java.util.*;
//import java.util.HashMap;
//import java.util.Set;

public class MajorityElement {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 4, 1, 5, 1 };

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (hm.containsKey(num)) {
                hm.put(num, hm.get(num) + 1);
            } else {
                hm.put(num, 1);
            }
        }

        Set<Integer> keySet = hm.keySet();
        for (int key : keySet) {
            if (hm.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }
}
