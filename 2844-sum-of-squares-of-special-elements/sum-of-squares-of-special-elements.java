class Solution {
    public int sumOfSquares(int[] arr) {
        int sq=0;
        for(int i=1;i<=arr.length;i++){
            if(arr.length%i==0){
                sq+=arr[i-1]*arr[i-1];
            }
        }
        return sq;
        
    }
}