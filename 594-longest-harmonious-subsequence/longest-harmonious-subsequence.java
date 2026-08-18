class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int maxlen = 0;
        while (j<nums.length) {
            while(nums[j]-nums[i]>1) {
                i++;
            }
            if (nums[j]-nums[i] == 1) {
                maxlen = Math.max(maxlen, j-i+1);
            }
            j++;
        }

        return maxlen;
    }
}