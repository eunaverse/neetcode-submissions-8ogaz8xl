class Solution {
    private static final String[] KEYS = {"","","abc","def","ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;

        ans.add("");
        
        // ""
        for(char digit: digits.toCharArray()){
            String letters = KEYS[digit  - '0'];
            List<String> next = new ArrayList<>();
            for (String prefix : ans) {
                for (int j = 0; j < letters.length(); j++) {
                    next.add(prefix + letters.charAt(j));
                }
            }
            ans = next;

        }

        return ans;
    }
}
