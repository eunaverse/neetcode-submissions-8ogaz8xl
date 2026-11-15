class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0

        words = list(set(wordList + [beginWord]))
        adj = {w: set() for w in words}

        # Build graph
        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                w1, w2 = words[i], words[j]

                diff = 0
                for a, b in zip(w1, w2):
                    if a != b:
                        diff += 1

                if diff == 1:
                    adj[w1].add(w2)
                    adj[w2].add(w1)

        # Dijkstra
        dist = {w: float('inf') for w in words}
        dist[beginWord] = 1

        min_heap = [(1, beginWord)]

        while min_heap:
            cost, cur = heapq.heappop(min_heap)

            if cur == endWord:
                return cost

            if cost > dist[cur]:
                continue

            for node in adj[cur]:
                if dist[node] > cost + 1:
                    dist[node] = cost + 1
                    heapq.heappush(min_heap, (dist[node], node))

        return 0