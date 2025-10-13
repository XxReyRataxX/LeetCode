class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] wr1 = word1.toCharArray();
        char[] wr2 = word2.toCharArray();
        StringBuilder sol = new StringBuilder(); // mejor que concatenar con +

        int i = 0, j = 0;
        // Mezclamos alternando caracteres
        while (i < wr1.length && j < wr2.length) {
            sol.append(wr1[i++]);
            sol.append(wr2[j++]);
        }

        // Si word1 tiene caracteres extra
        while (i < wr1.length) {
            sol.append(wr1[i++]);
        }

        // Si word2 tiene caracteres extra
        while (j < wr2.length) {
            sol.append(wr2[j++]);
        }

        return sol.toString();
    }
}
