class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}
class PrefixTree {
    private TrieNode node;
    public PrefixTree() {
        node = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = node;
        for(char c: word.toCharArray()){
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = node;
        for(char c: word.toCharArray()){
            if(cur.children[c-'a']==null) return false;
            cur = cur.children[c-'a'];
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = node;
        for(char c: prefix.toCharArray()){
            if(cur.children[c-'a']==null) return false;
            cur = cur.children[c-'a'];
        }
        return true;
    }
}
