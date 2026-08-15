class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int[] copy=new int[n];
        if(Arrays.equals(nums,copy)){
            return 0;
        }
        int ans=0;
        for(int num:nums){
            ans^=num;
        }
        return ans!=0?n:n-1;
        
    }
}