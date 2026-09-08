class Solution {
    public int countCommas(int n) {
        int count=0;
        int l=n-1000;
        while(n>=1000){
            count+=1;
            n=n/1000;
        }    
        if(count==0)
        {
            return 0;
        }  
        

        return count*l+1;
        
    }
}