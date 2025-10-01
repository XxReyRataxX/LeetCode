import java.util.*;

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind(n);

        // Unimos los índices según los pares
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        // Agrupamos los índices por su representante
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            groups.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }

        char[] c = s.toCharArray();

        // Para cada grupo, ordenamos los caracteres y los colocamos en los índices correspondientes
        for (List<Integer> indices : groups.values()) {
            List<Character> chars = new ArrayList<>();
            for (int index : indices) {
                chars.add(c[index]);
            }
            Collections.sort(chars);
            Collections.sort(indices); // ordenar índices para asignar en orden
            for (int i = 0; i < indices.size(); i++) {
                c[indices.get(i)] = chars.get(i);
            }
        }

        return new String(c);
    }
}

// Clase Union-Find (Disjoint Set Union)
class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]); // path compression
        return parent[x];
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) parent[px] = py;
    }
}
