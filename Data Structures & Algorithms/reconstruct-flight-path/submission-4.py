class Solution:
    def findItinerary(self, tickets):
        adj = defaultdict(list)

        for src, dst in tickets:
            heapq.heappush(adj[src], dst)

        res = []

        def dfs(cur):
            while adj[cur]:
                nxt = heapq.heappop(adj[cur])
                dfs(nxt)

            res.append(cur)

        dfs("JFK")
        return res[::-1]