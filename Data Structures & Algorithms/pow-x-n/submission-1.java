class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            return 1/multiply(x, Math.abs(n));
        }

        return multiply(x, n);
    }

 double multiply(double x, int n){
    if(n==0) return 1;
    double tmp = x;
    for(int i=1;i<n;i++){
      x = x*tmp;
    }
    return x;
  }
}
