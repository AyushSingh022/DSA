class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int res=n+1;
        int sum=0;
        int x=0;
        int[] dp=new int[n+1];
        Arrays.fill(dp,n);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            while(sum>target){
                sum-=arr[x++];
            }
                dp[i+1]=dp[i];
                if(sum==target){
                    res=Math.min(res,i-x+1+dp[x]);
                    dp[i+1]=Math.min(dp[i],i-x+1);
                }
        }
        return res==n+1?-1:res;
    }
}