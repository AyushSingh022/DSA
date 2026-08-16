class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length-1;
        int s=0;
        int e=n;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>nums[n]){
                if(nums[mid]<target){
                    s=mid+1;
                }
                else{
                    if(nums[0]>target){
                        s=mid+1;
                    }
                    else{
                        e=mid-1;
                    }
                }
                continue;
            }
            if(nums[mid]>target){
                e=mid-1;
            }
            else{
                if(nums[n]<target){
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }
            }


        }
        return -1;
        
    }
}