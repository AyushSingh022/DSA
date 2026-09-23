class Solution {
    public int minOperations(int[] nums, int x) {
        long total=0;
        for(int num:nums){
            total+=num;
        }
        if(total<x){
            return -1;
        }
        long target=total-x;
        if(target==0){
            return nums.length;
        }
        int n=nums.length;
        int left=0;
        int sum=0;
        int maxlen=-1;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            while(sum>target && left<=i){
                sum-=nums[left];
                left++;
            }
            if(sum==target){
                maxlen=Math.max(maxlen,i-left+1);
            }
        }
        return maxlen==-1?-1:n-maxlen;
        
    }
}