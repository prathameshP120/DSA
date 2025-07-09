import java.util.*;

public class HashMapCode {
    static class HashMap<K, V> { // K and V are generics(means it can be of any type)
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.value = value;
                this.key = key;

            }
        }

        private int N;
        private int n; // --> size(size of the linked list)
        private LinkedList<Node> buckets[]; // -->N=buckets.length

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>(); // buckets ke ek ek index pe ja kar linked list tayar ki he
            }
        }

        private int Hashfunction(K key) { // It will return the bucket index
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int SearchinLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            int di = 0;

            for (int i = 0; i < ll.size(); i++) {

                Node node = ll.get(di);

                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return di;
        }

        @SuppressWarnings("uncheked")
        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;

            buckets = new LinkedList[N * 2];

            N = N * 2;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }

        }

        public void put(K key, V value) {
            int bi = Hashfunction(key);
            int di = SearchinLL(key, bi); // Valid ; -1

            if (di != -1) { // node already exist
                Node node = buckets[bi].get(di);
                node.value = value;

            } else {
                buckets[bi].add(new Node(key, value));
                n++;

            }

            double lambada = (double) n / N;
            if (lambada > 2.0) {
                rehash();
            }
        }

        public boolean containKey(K key) {
            int bi = Hashfunction(key);
            int di = SearchinLL(key, bi);

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {
            int bi = Hashfunction(key);
            int di = SearchinLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = Hashfunction(key);
            int di = SearchinLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 10);
        hm.put("Bhutan", 5);
        ArrayList<String> keys = hm.keySet();

        for (String key : keys) {
            System.out.println(key);
        }
    }

}
