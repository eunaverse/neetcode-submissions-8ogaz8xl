class TrieNode{
    TrieNode[] children = new TrieNode[26];
    String word = null;
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String s : words){
            TrieNode cur = root;

            for(char c: s.toCharArray()){
                if(cur.children[c-'a']==null){
                    cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            cur.word = s;
        }

        int row = board.length;
        int col = board[0].length;
       
        List<String> ans = new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dfs(board, i, j, root, ans);
            }
        }
        return ans;
    }

    void dfs(char[][] board, int r, int c, TrieNode node, List<String> ans){
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        char ch = board[r][c];
        if(ch=='#') return;
        TrieNode next = node.children[ch-'a'];
        if(next == null) return;
        if(next.word!=null){
            ans.add(next.word);
            next.word = null;
        }
        board[r][c] = '#';
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int d = 0; d < 4; d++) {
            dfs(board, r + dr[d], c + dc[d], next, ans);
        }
        board[r][c] = ch;
    }

    
}
