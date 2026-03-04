/*
 * @lc app=leetcode id=1582 lang=java
 *
 * [1582] Special Positions in a Binary Matrix
 */

// @lc code=start
class Solution {
    public int numSpecial(int[][] mat) {
        int posicionesesp = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != 1) {
                    continue;
                }

                boolean especial = true;

                for (int col = 0; col < mat[i].length; col++) {
                    if (col != j && mat[i][col] == 1) {
                        especial = false;
                        break;
                    }
                }

                if (!especial) {
                    continue;
                }

                for (int fila = 0; fila < mat.length; fila++) {
                    if (fila != i && mat[fila][j] == 1) {
                        especial = false;
                        break;
                    }
                }

                if (especial) {
                    posicionesesp++;
                }
            }
        }

        return posicionesesp;
    }
}
// @lc code=end

