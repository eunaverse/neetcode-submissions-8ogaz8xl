class Solution {
    public int characterReplacement(String s, int k) {
        /*
        AAABABB
         l    r 
        count
        A:3 maxFreq: 3 maxFreqChar: A
        B: 1 maxFreq: 3 maxFreqChar: A -> k>0: k--
        A: 4 B: 1 maxFreq: 4 
        A: 4 B:2 maxFreq: 4 maxFreqChar: A -> k==0 => res:5
        A: 3 B: 3 maxFreq: 3 maxFeqChar: A        
        */

        int l = 0, r=0;
        int res = 0;
        int maxFreq=0;
        int[] freq = new int[26];
        while(r<s.length()){
            char cur = s.charAt(r);
            freq[cur-'A']++;
            if(freq[cur-'A'] > maxFreq){
                maxFreq = freq[cur-'A'];
            }
            int len = r-l+1;
            if(len-maxFreq <= k){
                res = Math.max(len, res);
            }
            else{
                freq[s.charAt(l++)-'A']--;
            }
            r++;
        }
        return res;

    }
}
