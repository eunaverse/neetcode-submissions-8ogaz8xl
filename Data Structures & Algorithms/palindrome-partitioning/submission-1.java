class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(new ArrayList<>(), 0, s);

        return ans;
    }

    void backtrack(List<StringBuilder> candidates, int idx, String s) {
        if (idx == s.length()) {
            List<String> temp = new ArrayList<>();
            for (StringBuilder sb : candidates) {
                if (!isPalindrome(sb.toString())) return;
                temp.add(sb.toString());
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        candidates.add(new StringBuilder().append(s.charAt(idx)));
        backtrack(candidates, idx + 1, s);
        candidates.removeLast();
        if (!candidates.isEmpty()) {
            StringBuilder sb = candidates.getLast();
            sb.append(s.charAt(idx));
            backtrack(candidates, idx + 1, s);
        }
    }

    boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}

