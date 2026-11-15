class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        a, b, c = 0, 0, 0

        for x, y, z in triplets:
            if x > target[0] or y > target[1] or z > target[2]:
                continue
            a = max(a, x)
            b = max(b, y)
            c = max(c, z)
        
        return [a, b, c] == target
