class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length-1;
        for(int i=0;i<row;i++){
            Arrays.sort(grid[i]);
        }
        int sum=0;
        while(col>=0){
            int max=Integer.MIN_VALUE;
            int i=0;
            while(i<row){
                max=Math.max(max,grid[i][col]);
                i++;
            }
            sum+=max;
            col--;
        }
        return sum;
        
    }
}