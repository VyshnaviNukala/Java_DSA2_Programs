class Solution {
    public double myPow(double x, int n) {
        if(n == -2147483648) return 0;
        if(n >= 0) return ans(x,n);
        else return 1 / ans(x,-1*n);
    }

    double ans(double x,int n){
        double ans = 1;
        while(n > 0){
            if((n & 1) == 1){
                ans *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return ans;
    }
}