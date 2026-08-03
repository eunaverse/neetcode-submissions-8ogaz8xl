class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        # "("
        # open: 2, closed:3
        # open > closed -> invalid 

        res = []
        tmp = []
        def dfs(opened: int, closed: int):
            if opened > closed:
                return
            if opened == 0 and closed == 0:
                res.append("".join(tmp))
                return
            
            if opened > 0:
                tmp.append("(")
                dfs(opened-1, closed)
                tmp.pop()
            if closed > 0:
                tmp.append(")")
                dfs(opened, closed-1)
                tmp.pop()
        
        dfs(n, n)
        return res