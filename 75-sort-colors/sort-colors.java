class Solution {
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                int swap=nums[mid];
                nums[mid]=nums[low];
                nums[low]=swap;
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                int swap=nums[mid];
                nums[mid]=nums[high];
                nums[high]=swap;
                high--;
                
            }
        }
        System.out.print("[");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.print("]");

        
    }
}