class Solution {
    public int minMoves(int[] nums) {
        int max=0;
        for(int n:nums){
            max=Math.max(n,max);
        }
        int ans=0;
        for(int num:nums){
            ans+=Math.abs(max-num);
        }
        return ans;        
    }
}