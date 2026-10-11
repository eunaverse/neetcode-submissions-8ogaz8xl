class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj = {i: [] for i in range(1, n + 1)}
        for t in times:
            n1,n2,n3 = t
            if n2 not in adj[n1]:
                adj[n1].append((n2,n3))

        visited = [float('inf')] * (n + 1)
        minHeap = []
        visited[k] = 0
        heapq.heappush(minHeap, (0, k))

        while len(minHeap) > 0:
            dist, node = heapq.heappop(minHeap)

            if visited[node] < dist:
                continue

            for nextNode, cost in adj[node]:
                nextCost = cost + dist
                if visited[nextNode] > nextCost:
                    visited[nextNode] = nextCost
                    heapq.heappush(minHeap, (nextCost, nextNode))
                
        res = max(visited[1:])

        return -1 if res == float('inf') else res
            
