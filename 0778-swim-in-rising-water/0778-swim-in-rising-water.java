import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visitado = new boolean[n][n];

        // PriorityQueue: [elevación, x, y], ordenada por elevación ascendente
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0}); // empezamos en la esquina superior izquierda
        visitado[0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int tiempo = 0;

        while (!pq.isEmpty()) {
            int[] actual = pq.poll();
            int elev = actual[0];
            int x = actual[1];
            int y = actual[2];

            // El tiempo mínimo es el máximo de elevaciones que hemos cruzado
            tiempo = Math.max(tiempo, elev);

            // Si llegamos al objetivo, devolvemos el tiempo
            if (x == n - 1 && y == n - 1) {
                return tiempo;
            }

            // Revisamos vecinos 4-direccionales
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visitado[nx][ny]) {
                    visitado[nx][ny] = true;
                    pq.offer(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }

        return -1; // nunca debería llegar aquí
    }
}
