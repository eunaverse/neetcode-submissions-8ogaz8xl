class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        visited = set()
        adj = {key:set() for key in range(n)}

        for s,d in edges:
            adj[s].add(d)
            adj[d].add(s)
        

        def dfs(node, par):
            if node in visited:
                return False
            
            visited.add(node)
            
            for d in adj[node]:
                if d == par:
                    continue
                if not dfs(d, node):
                    return False
            return True
        
        return dfs(0, -1) and len(visited) == n