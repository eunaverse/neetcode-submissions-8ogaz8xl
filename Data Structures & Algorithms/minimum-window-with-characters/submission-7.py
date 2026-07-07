class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t): return ""

        word = {}
    
        for c in t:
            word[c] = word.get(c, 0) + 1
    
        res = [-1, -1]
        resLen = 1001
        l = 0
        matches = 0
        need = len(word)
        sWord = {}
        for r in range(len(s)):
            sWord[s[r]] = sWord.get(s[r], 0) + 1

            if s[r] in word and sWord[s[r]] == word[s[r]]:
                matches+=1
            
            while matches == need:
                if resLen > r-l+1:
                    resLen = r-l+1
                    res = [l, r]
                sWord[s[l]]-=1
                if s[l] in word and sWord[s[l]] == word[s[l]] - 1:
                    matches-=1
                l+=1
            
        l, r = res
        return "" if resLen == 1001 else s[l:r + 1]