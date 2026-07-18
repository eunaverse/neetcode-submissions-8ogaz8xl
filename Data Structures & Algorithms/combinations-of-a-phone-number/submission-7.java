class Solution {
    private static final String[] KEYS = {"","","abc","def","ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;
        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    void backtrack(String digits, int idx, StringBuilder sb, List<String> ans){

        if(digits.length() == idx) {
            ans.add(sb.toString());
            return;
        }
        String letters = KEYS[digits.charAt(idx)-'0'];
        for(int i = 0; i<letters.length();i++){
            backtrack(digits, idx+1, sb.append(letters.charAt(i)), ans);
            sb.deleteCharAt(sb.length()-1);
        }
    } 
}
