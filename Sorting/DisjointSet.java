package Sorting;

public class DisjointSet {
    
    private int[] parent;
    private int[] size;

    public DisjointSet (int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i <n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find (int x) {

        if(parent[x] != x) {
            parent[x] = find(parent[x]); // Path Compression
        }
        return parent[x];
    }

    public void union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
        return;

        if (size[rootX] < size[rootY]) {
            
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }else {

            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public boolean connected (int x, int y) {
        return find(x) == find(y);
    }
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(6);

        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(0, 4);

        System.out.println(ds.connected(0, 2));
        System.out.println(ds.connected(0, 5));
    }
}