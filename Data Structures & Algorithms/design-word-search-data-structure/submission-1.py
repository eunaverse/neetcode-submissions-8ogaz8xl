class TrieNode:
    def __init__(self):
        self.children = [None]*26
        self.word = False
class WordDictionary:

    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        cur = self.root
        for c in word:
            i = ord(c) - ord('a')
            if cur.children[i] == None:
                cur.children[i] = TrieNode()
            cur = cur.children[i]
        cur.word=True

    def search(self, word: str) -> bool:
        def dfs(j, root):
            cur = root
            for i in range(j, len(word)):
                idx = ord(word[i]) - ord('a')
                if word[i] != '.':
                    if cur.children[idx]==None: return False
                else:
                    for c in range(0, 26):
                        if cur.children[c]!=None:
                            if dfs(i+1, cur.children[c]):
                                return True
                    return False
                cur = cur.children[idx]
            return cur.word
        return dfs(0, self.root)

            
