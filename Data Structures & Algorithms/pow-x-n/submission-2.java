class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            return 1/multiply(x, Math.abs(n));
        }

        return multiply(x, n);
    }

 double multiply(double x, int n){
    double res = 1;
    while(n>0){
        if((n&1)==1) {
            res *= x;
        }
        x *=x;
        n >>=1;
    }
    return res;
}
}
