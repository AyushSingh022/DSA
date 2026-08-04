class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        List<Integer>ans=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            set.add(num);
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        for(int i=min+1;i<max;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;

    }
}