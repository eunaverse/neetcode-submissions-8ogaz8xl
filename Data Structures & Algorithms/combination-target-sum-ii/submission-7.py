class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        tmp = []
        candidates.sort()

        def dfs(idx: int, target: int):
            if target < 0:
                return
            if target==0:
                res.append(tmp[:])
                return
            if idx >= len(candidates):
                return
            
            tmp.append(candidates[idx])
            dfs(idx+1, target-candidates[idx])

            while idx+1 < len(candidates) and candidates[idx] == candidates[idx+1]:
                idx+=1
            
            tmp.pop()
            dfs(idx+1, target)

        dfs(0, target)
        return res