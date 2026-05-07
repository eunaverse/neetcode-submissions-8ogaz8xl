class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        if(s1.length() > s2.length()) return false;

        for(int i=0;i<s1.length();i++){
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++;
        }

        int l = 0, r = s1.length()-1;
        s2Count[s2.charAt(r)-'a']--;

        while(r<s2.length()){
            s2Count[s2.charAt(r)-'a']++;
            for(int i=0;i<26;i++){
                if(s1Count[i]!=s2Count[i]){
                    s2Count[s2.charAt(l++)-'a']--;
                    break;
                }
            }
            if(r-l+1 == s1.length()) return true;
            r++;
        }

        return false;

    }
}
