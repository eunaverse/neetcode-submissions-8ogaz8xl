class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res=new ArrayList<>();
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        
        int idx=0;
        while(idx<s.length()){
            int maxIdx=idx;
        
            for(int i=idx;i<=maxIdx;i++){
            maxIdx=Math.max(maxIdx, map.get(s.charAt(i)));
            }
            res.add(maxIdx-idx+1);
            idx=maxIdx+1;
        }

        return res;
    }
}
