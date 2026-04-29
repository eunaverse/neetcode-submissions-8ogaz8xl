class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
    
        int sum = digits[digits.length-1] + 1;
        List<Integer> res = new ArrayList<>();
        if(sum>9){
            carry=1;
            sum=0;
        }
        res.add(sum);

        for(int i=digits.length-2; i>=0; i--){
            sum = digits[i] + carry;
            if(sum>9){
                carry = 1;
                sum=0;
            }
            else carry=0;
            res.add(sum);
        }
        if(carry>0) res.add(carry);

        int[] result = new int[res.size()];
        int idx = res.size()-1;
        for(Integer num: res){
            result[idx--] = num;
        }
        return result;
    }
}
