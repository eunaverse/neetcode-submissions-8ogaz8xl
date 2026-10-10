class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2): return False

        s1_count = {}
        s2_count = {}

        l = 0
        r = 0

        for s in s1:
            s1_count[s] = s1_count.get(s, 0) + 1
            s2_count[s2[r]] = s2_count.get(s2[r], 0) + 1
            r+=1
        
        if s1_count == s2_count:
            return True
     
        while r < len(s2):
            s2_count[s2[l]] -= 1
            if s2_count[s2[l]] == 0:
                del s2_count[s2[l]]
            l+=1
            s2_count[s2[r]] = s2_count.get(s2[r],0) + 1
            r+=1
            if s1_count == s2_count:
                return True
            
        return False
                

        