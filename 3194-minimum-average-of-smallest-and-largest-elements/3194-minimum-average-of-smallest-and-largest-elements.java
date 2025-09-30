import java.util.ArrayList;

class Solution {
    public double minimumAverage(int[] nums) {
        ArrayList<Float> medias = new ArrayList<>();
        int x = nums.length / 2;

        ArrayList<Integer> conjunto = new ArrayList<>();
        for (int num : nums) {
            conjunto.add(num);
        }

        for (int i = 1; i <= x; i++) {
            int minimo = Integer.MAX_VALUE;
            int maximo = Integer.MIN_VALUE;
            int indicemax = 0;
            int indicemin = 0;

            for (int r = 0; r < conjunto.size(); r++) {
                int num = conjunto.get(r);
                if (num < minimo) {
                    minimo = num;
                    indicemin = r;
                }
                if (num > maximo) {
                    maximo = num;
                    indicemax = r;
                }
            }

            // Eliminar primero el índice mayor para no desordenar
            if (indicemax > indicemin) {
                conjunto.remove(indicemax);
                conjunto.remove(indicemin);
            } else {
                conjunto.remove(indicemin);
                conjunto.remove(indicemax);
            }

            medias.add((float) (minimo + maximo) / 2);
        }

        float minimo1 = Float.MAX_VALUE;
        for (int i = 0; i < medias.size(); i++) {
            if (medias.get(i) < minimo1) {
                minimo1 = medias.get(i);
            }
        }

        return minimo1;
    }
}
