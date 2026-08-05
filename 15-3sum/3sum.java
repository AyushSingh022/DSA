class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int left=0;
        List<List<Integer>> res=new ArrayList<>();
        int right=n-1;
        int sum=0;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            left=i+1;
            right=n-1;
            sum=-1*nums[i];
            while(left<right){
                int s=nums[left]+nums[right];
                if(s==sum){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<n && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(right>0 && nums[right]==nums[right+1]){
                        right--;
                    }
                }
                else if(s<sum){
                    left++;
                }
                else{
                    right--;
                }
            }

        }
        return res;
    }
}