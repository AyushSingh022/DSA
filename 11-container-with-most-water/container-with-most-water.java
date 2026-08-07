class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int current=0;
        int maxarea=0;
        while(left<right){
             current=Math.min(height[left],height[right])*(right-left);
            maxarea=Math.max(current,maxarea);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxarea;
    }
}