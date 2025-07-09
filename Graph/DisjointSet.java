import java.util.ArrayList;

class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {

        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int ultimate_parent(int n) {
        if (n == parent.get(n)) {
            return n;
        }
        int ulp = ultimate_parent(parent.get(n));
        parent.set(n, ulp);
        return parent.get(n);

    }

    public void unionByRank(int u, int v) {
        int pu = ultimate_parent(u);
        int pv = ultimate_parent(v);
        if (pu == pv)
            return;
        if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
        } else if (rank.get(pv) < rank.get(pu)) {
            parent.set(pv, pu);
        } else {
            parent.set(pv, pu);
            int rankU = rank.get(pu);
            rank.set(pu, rankU + 1);
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        ds.unionByRank(3, 4);
        if (ds.ultimate_parent(3) == ds.ultimate_parent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

    }
}