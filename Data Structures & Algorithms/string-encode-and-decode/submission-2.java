class Solution {

    public String encode(List<String> strs) {
        String del = "#";

        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length()).append(del).append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        String del = "#";
        List<String> result = new ArrayList<>();
        int i = 0;

          while (i < str.length()) {
              int j = i;

              while (str.charAt(j) != '#') {
                  j++;
              }

              int len = Integer.parseInt(str.substring(i, j));
              j++;

              result.add(str.substring(j, j + len));
              i = j + len;
          }


        return result;
    }
}
