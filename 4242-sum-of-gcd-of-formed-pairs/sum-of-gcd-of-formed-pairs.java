class Solution {
    public long gcdSum(int[] nums) {
        int[] prefix=new int[nums.length];
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            prefix[i]=gcd(max,nums[i]);
        }
        Arrays.sort(prefix);
        long ans=0;
        int n=nums.length;
        for(int i=0;i<prefix.length/2;i++){
            ans+=gcd(prefix[i],prefix[n-1-i]);
        }
        return ans;        
    }
    static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}