class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        int num=1;
        for(int i=1;i<=n;i++){
            if((i&1)==1){
                res[i]=res[i>>1]+1;
            }
            else{
                if(i==(1<<num)){
                    res[i] = 1;
                    num++;
                }
                else{ res[i]=res[i>>1];}
            }
        }
        return res;
    }
}
