class Solution {
    public int maxProfit(int[] prices) {
        int maxB=-1;
        int maxP=0;
        for(int i=0;i<prices.length;i++){
            if(maxB!=-1&&maxB<prices[i]){
                maxP=Math.max(maxP, prices[i]-maxB);
            }
            else{
                maxB=prices[i];
            }
        }

        return maxP;
    }
}
