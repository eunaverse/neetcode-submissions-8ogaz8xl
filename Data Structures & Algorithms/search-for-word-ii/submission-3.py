class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = TrieNode()
        for w in words:
            cur = root
            for s in w:
                idx = ord(s) - ord('a')
                if cur.children[idx] is None:
                    cur.children[idx] = TrieNode()
                cur = cur.children[idx]
            cur.word = w
        ans = []
                
        def dfs(cr, cc, cur: TrieNode):
            if cur.word is not None:
                ans.append(cur.word)
                cur.word = None

            if cr < 0 or cr >= len(board) or cc < 0 or cc >= len(board[0]) or board[cr][cc] == '#':
                return
            ch = board[cr][cc]
            if cur.children[ord(ch) - ord('a')] is None:
                return

            board[cr][cc] = '#'
            dfs(cr+1, cc, cur.children[ord(ch) - ord('a')])
            dfs(cr-1, cc, cur.children[ord(ch) - ord('a')])
            dfs(cr, cc+1, cur.children[ord(ch) - ord('a')])
            dfs(cr, cc-1, cur.children[ord(ch) - ord('a')])
            board[cr][cc] = ch
        
        for r in range(len(board)):
            for c in range(len(board[0])):
                dfs(r, c, root)
        return ans
        

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.word = None
    
    
        