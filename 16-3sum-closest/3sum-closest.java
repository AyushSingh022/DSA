class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close=Integer.MAX_VALUE/2;
        for(int i=0;i<nums.length-2;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
            int current=nums[i]+nums[left]+nums[right];
            if(Math.abs(current-target)<Math.abs(close-target)){
                close=current;
            }
            if(current<target){
                left++;
            }
            else if(current>target){
                right--;
            }
            else{
                return current;
            }
            }
        }
        return close;
        
    }
}