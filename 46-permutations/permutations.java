class Solution {
    void permute(int idx,int[] nums,List<List<Integer>> ans){
        if(idx==nums.length){
            List<Integer>list=new ArrayList<>();
            for(int num:nums){
                list.add(num);
            }
            ans.add(list);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            int temp=nums[i];
            nums[i]=nums[idx];
            nums[idx]=temp;
            permute(idx+1,nums,ans);
            int temp2=nums[i];
            nums[i]=nums[idx];
            nums[idx]=temp2;

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList();
        permute(0,nums,ans);
        return ans;
        
    }
}