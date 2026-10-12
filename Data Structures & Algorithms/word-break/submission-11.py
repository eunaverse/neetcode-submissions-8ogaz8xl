class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        trie = Trie()

        for w in wordDict:
            trie.insert(w)
        
        dp = [False] * (len(s) + 1)
        dp[0] = True

        for i in range(len(s)):
            if not dp[i]:
                continue
            for j in range(i, len(s)):
                if trie.search(s, i, j):
                    dp[j+1] = True ## 
        return dp[len(s)]

                
class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_word = False
    
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        node = self.root
        for w in word:
            if w not in node.children:
                node.children[w] = TrieNode()
            node = node.children[w]
        node.is_word = True
    
    def search(self, s, i, j):
        node = self.root
        for idx in range(i, j + 1):
            if s[idx] not in node.children:
                return False
            node = node.children[s[idx]]
        return node.is_word





