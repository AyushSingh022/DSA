class Solution {
    public int trap(int[] height) {
        int total=0;
        int leftMax=0;
        int rightMax=0;
        int start=0;
        int end=height.length-1;
        for(int i=0;i<height.length;i++){
            rightMax=Math.max(rightMax,height[end]);
            leftMax=Math.max(leftMax,height[start]);
            if(leftMax<rightMax){
                total+=leftMax-height[start];
                start++;
            }
            else{
                total+=rightMax-height[end];
                end--;
            }
        }
        return total;
        }

    }
