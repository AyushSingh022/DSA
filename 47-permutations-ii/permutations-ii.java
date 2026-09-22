class Solution {
    void permute(int idx,int[] nums,List<List<Integer>>ans){
        if(idx==nums.length){
            List<Integer>list=new ArrayList<>();
            for(int num:nums){
                list.add(num);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        Set<Integer> st=new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            if(st.contains(nums[i])){
                continue;
            }
            st.add(nums[i]);
            int temp=nums[i];
            nums[i]=nums[idx];
            nums[idx]=temp;
            permute(idx+1,nums,ans);
            int temp2=nums[i];
            nums[i]=nums[idx];
            nums[idx]=temp2;

        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        permute(0,nums,ans);
        return ans;
        
    }
}