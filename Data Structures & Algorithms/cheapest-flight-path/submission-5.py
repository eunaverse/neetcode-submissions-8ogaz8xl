class Solution:
    def findCheapestPrice(self, n, flights, src, dst, k):
        adj = {i: [] for i in range(n)}

        for u, v, cost in flights:
            adj[u].append((cost, v))

        # dist[node][flights_used]
        dist = [[float('inf')] * (k + 2) for _ in range(n)]
        dist[src][0] = 0

        min_heap = [(0, 0, src)]  # cost, flights_used, node

        while min_heap:
            cur_cost, used, node = heapq.heappop(min_heap)

            if node == dst:
                return cur_cost

            if cur_cost > dist[node][used]:
                continue

            if used == k + 1:
                continue

            for edge, next_node in adj[node]:
                next_cost = cur_cost + edge
                next_used = used + 1

                if next_cost < dist[next_node][next_used]:
                    dist[next_node][next_used] = next_cost
                    heapq.heappush(
                        min_heap,
                        (next_cost, next_used, next_node)
                    )

        return -1