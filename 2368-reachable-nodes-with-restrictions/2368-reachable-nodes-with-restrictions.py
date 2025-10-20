# @lc app=leetcode id=2368 lang=python
#
# [2368] Reachable Nodes With Restrictions
#

# @lc code=start
class Solution(object):
    def reachableNodes(self, n, edges, restricted):
        """
        :type n: int
        :type edges: List[List[int]]
        :type restricted: List[int]
        :rtype: int
        """
        # Creamos un mapa de adyacencia para acceso O(1)
        graph = [[] for _ in range(n)]
        for a, b in edges:
            graph[a].append(b)
            graph[b].append(a)

        visited = set()
        restricted = set(restricted)
        visited.add(0)
        self.siguiente(visited, graph, 0, restricted)
        return len(visited)
    
    def siguiente(self, visited, graph, origen, restricted):
        # Iteramos sobre los vecinos directos (sin escanear todo edges)
        for vecino in graph[origen]:
            if vecino not in restricted and vecino not in visited:
                visited.add(vecino)
                self.siguiente(visited, graph, vecino, restricted)
# @lc code=end
