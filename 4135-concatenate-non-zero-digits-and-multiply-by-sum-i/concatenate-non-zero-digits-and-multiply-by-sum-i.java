class Solution {
    public long sumAndMultiply(int n) {
        long x=0;
        long sum=0;
        long a=1;
        while(n>0){
            int b=n%10;
            if(b!=0){
                x=b*a+x;
                a*=10;
                sum+=b;
            }
            n/=10;
        }
        return x*sum;
                
    }
}