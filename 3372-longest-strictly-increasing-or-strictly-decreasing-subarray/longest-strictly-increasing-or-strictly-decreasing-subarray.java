class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int res=1;
        int max=1;
        int min=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                max++;
                min=1;
            }
            else if(nums[i]<nums[i-1]){
                min++;
                max=1;
            }
            else{
                max=1;
                min=1;
            }
            res=Math.max(res,Math.max(max,min));
        }
        return res;
        
    }
}