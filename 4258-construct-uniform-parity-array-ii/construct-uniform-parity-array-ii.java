class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE;
        for(int n:nums1){
            if((n&1)==1){
                min=Math.min(n,min);
            }
        }
        final int minodd=min;
        IntPredicate helper=(p)->{
            for(int n:nums1){
                if ((n & 1) == 0 && minodd != Integer.MAX_VALUE && n < minodd) {
                return false;
            }
            }
            return true;
        };
        return helper.test(0) || helper.test(1);
        
    }
}