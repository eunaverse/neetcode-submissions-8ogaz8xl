class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder stb = new StringBuilder();
        for(String s: strs){
            stb.append(s.length()).append("#").append(s);
        }

        return stb.toString(); // O(1)
    }

    public List<String> decode(String str) {
        if(str.length()==0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int size = Integer.parseInt(str.substring(i,j));
            j++;
            res.add(str.substring(j, j+size));
            i = j + size;
        }

        return res;

    }
}
