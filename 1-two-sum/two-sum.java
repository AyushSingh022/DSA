class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>hs=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hs.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int s=target-nums[i];
            if(hs.containsKey(s) && hs.get(s)!=i){
                return new int[]{i,hs.get(s)};
            }
        }
        return new int[]{};
        
    }
}