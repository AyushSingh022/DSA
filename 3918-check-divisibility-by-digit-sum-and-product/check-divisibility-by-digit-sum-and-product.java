class Solution {
    public boolean checkDivisibility(int n) {
        int x=n;
        int s=0;
        int p=1;
        while(x!=0){
            int num=x%10;
            s+=num;
            p*=num;
            x/=10;
        }
        return (n%(s+p)==0);
        
    }
}