class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        indegree = {c: 0 for w in words for c in w}
        adj = defaultdict(set)

        for i in range(len(words) - 1):
            word1 = words[i]
            word2 = words[i + 1]

            if len(word1) > len(word2) and word1.startswith(word2):
                return ""

            for k in range(min(len(word1), len(word2))):
                if word1[k] != word2[k]:
                    u, v = word1[k], word2[k]

                    if v not in adj[u]:
                        adj[u].add(v)
                        indegree[v] += 1

                    break
        

        pq = [key for key in indegree if indegree[key] == 0]
        heapq.heapify(pq)
        res = []
        while pq:
            cur = heapq.heappop(pq)
            res.append(cur)

            for next_w in adj[cur]:
                indegree[next_w]-=1
                if indegree[next_w]==0:
                    heapq.heappush(pq, next_w)
        
        
        return "".join(res) if len(res) == len(indegree) else ""

                    
            
                


                
                
