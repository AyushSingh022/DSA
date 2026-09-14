class Solution {
    public int pivotIndex(int[] nums) {
        int left=0;
        int right=0;
        int sum=0;
        for(int s:nums){
            sum+=s;
        }
        if(sum-nums[0]==0){
            return 0;
        }
        for(int i=1;i<nums.length;i++){
            left+=nums[i-1];
            right=sum-nums[i]-left;
            if(left==right){
                return i;
            }
        }
        return -1;


        
    }
}