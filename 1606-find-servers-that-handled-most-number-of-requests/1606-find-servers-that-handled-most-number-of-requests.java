import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] count = new int[k];
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) available.add(i);

        // busy = (endTime, serverId)
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];
            int duration = load[i];

            // Liberar los servidores que ya terminaron
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                available.add(busy.poll()[1]);
            }

            if (available.isEmpty()) continue; // todos ocupados → drop

            int target = i % k;
            Integer server = available.ceiling(target); // buscar >= target
            if (server == null) server = available.first(); // wrap-around

            // Asignar request
            available.remove(server);
            busy.add(new int[]{time + duration, server});
            count[server]++;
        }

        // Encontrar el máximo número de peticiones atendidas
        int max = Arrays.stream(count).max().getAsInt();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) result.add(i);
        }
        return result;
    }
}
