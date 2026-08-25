class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> hs=new HashSet<>();
        for(int n:nums){
            hs.add(n);
        }
        int c=k;
        while(hs.contains(c)){
            c+=k;
        }
        return c;

        
    }
}