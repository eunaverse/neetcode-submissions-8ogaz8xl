class Solution {
    public String decodeString(String s) {
        int repeat = 0;
        Stack<Integer> nums = new Stack<>();
        Stack<String> chr = new Stack<>();
        StringBuilder stb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                repeat = repeat * 10 + c-'0';
            }
            else{
                if(c == '['){
                    nums.push(repeat);
                    chr.push(stb.toString());
                    repeat = 0;
                    stb = new StringBuilder();   
                }
                else if(c ==']'){
                    String tmp = stb.toString();
                    stb = new StringBuilder(chr.pop());
                    int count = nums.pop();
                    for(int i=0;i<count;i++){
                        stb.append(tmp);
                    }
                }
                else{
                    stb.append(c);
                }

            }

        }
        return stb.toString();
    }
}